package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal;
import hun.restoffice.remoteClient.domain.RegisterCloseStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@WebServlet("/RegisterClose")
public class RegisterCloseServlet extends HttpServlet {

    private static final String DAILY_CLOSE_SESSION_KEY = "dailyClose";

    private static final Logger log = Logger.getLogger(RegisterCloseServlet.class);
    /*
     * (non-Javadoc)
     *
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        log.info("RegisterClose#doGet invoked");

        DailyCloseFacadeLocal dailyClose = (DailyCloseFacadeLocal) request.getSession()
                .getAttribute(DAILY_CLOSE_SESSION_KEY);

        List<RegisterCloseStub> registers = new ArrayList<>();
        try {
            registers = dailyClose.getRegistersToClose();
        } catch (FacadeException e) {
            log.error(e);
        }
        request.setAttribute("registers", registers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterClose.jsp");
        dispatcher.forward(request, response);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        log.info("RegisterClose#doPost invoked");

        DailyCloseFacadeLocal dailyClose = (DailyCloseFacadeLocal) request.getSession()
                .getAttribute(DAILY_CLOSE_SESSION_KEY);

        try {
            for (RegisterCloseStub register : dailyClose.getRegistersToClose()) {
                String registerId = register.getRegisterStub().getRegisterId();
                boolean isClosed = Boolean.parseBoolean(request.getParameter(registerId + ":isClosed"));
                int closeNo = Integer.parseInt(request.getParameter(registerId + ":closeNo"));
                BigDecimal closeAmt = new BigDecimal(request.getParameter(registerId + ":closeAmt"));

                if (isClosed) {
                    register.setCloseNo(closeNo);
                    register.setCloseAmt(closeAmt);
                }
            }
        } catch (FacadeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("EmployeeShiftClose");
    }
}
