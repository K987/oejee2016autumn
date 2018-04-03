package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.EmployeeShiftCloseStub;
import hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal;
import hun.restoffice.persistence.entity.employee.JobPosition;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@WebServlet("/EmployeeShiftClose")
public class EmployeeShiftCloseServlet extends HttpServlet {

    private static final String DAILY_CLOSE_SESSION_KEY = "dailyClose";
    private static final Logger log = Logger.getLogger(EmployeeShiftCloseServlet.class);

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
        log.info("EmployeeShiftCloseServlet#doGet invoked");

        DailyCloseFacadeLocal dailyClose = (DailyCloseFacadeLocal) request.getSession()
                .getAttribute(DAILY_CLOSE_SESSION_KEY);

        List<EmployeeShiftCloseStub> employeeShifts = new ArrayList<>();
        try {
            employeeShifts = dailyClose.getEmployeeShiftToClose();
        } catch (FacadeException e) {
            log.error(e);
        }

        request.setAttribute("employeeShifts", employeeShifts);
        request.setAttribute("positions", JobPosition.values());
        RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeShiftClose.jsp");
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
    }
}
