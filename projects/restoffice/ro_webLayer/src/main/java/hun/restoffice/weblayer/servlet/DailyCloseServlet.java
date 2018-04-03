package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal;

/**
 *
 */
@WebServlet("/DailyClose")
public class DailyCloseServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(DailyCloseServlet.class);
    private static final String DAILY_CLOSE_SESSION_KEY = "dailyClose";

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
        RequestDispatcher dispatcher = null;

        Boolean reset = paramToBool(request.getParameter("reset"));
        DailyCloseFacadeLocal dailyClose = (DailyCloseFacadeLocal) request.getSession()
                .getAttribute(DAILY_CLOSE_SESSION_KEY);

        if (reset == null) {
            request.setAttribute("onGoingClose", false);

            if (dailyClose != null) {
                request.setAttribute("onGoingClose", true);
                request.setAttribute("closeDate", dailyClose.getCloseDay());
            }
            dispatcher = request.getRequestDispatcher("DailyClose.jsp");
            dispatcher.forward(request, response);
        } else if (reset) {
            dailyClose.remove();
            request.getSession().removeAttribute(DAILY_CLOSE_SESSION_KEY);
            response.sendRedirect("RestOffice");
        } else {
            response.sendRedirect("RegisterClose");
        }

    }

    /**
     * @param parameter
     * @return
     */
    private Boolean paramToBool(final String parameter) {
        if (parameter == null)
            return null;
        else
            return Boolean.parseBoolean(parameter);

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
        DailyCloseFacadeLocal dailyClose = (DailyCloseFacadeLocal) request.getSession()
                .getAttribute(DAILY_CLOSE_SESSION_KEY);

        if (dailyClose == null) {
            InitialContext ic;
            try {
                ic = new InitialContext();
                dailyClose = (DailyCloseFacadeLocal) ic.lookup(
                        "java:global/restOffice/ro_ejbLayer/DailyCloseFacade!hun.restoffice.ejbservice.facade.DailyCloseFacadeLocal");
                request.getSession().setAttribute(DAILY_CLOSE_SESSION_KEY, dailyClose);
            } catch (NamingException e) {
                log.error(e);
            }

            Calendar cal = formatCalendar(request.getParameter("closeDate"));
            dailyClose.setCloseDay(cal);
        }
        response.sendRedirect("RegisterClose");
    }

    /**
     * @param parameter
     * @return
     */
    private Calendar formatCalendar(final String parameter) {
        if (parameter == null && "".equals(parameter))
            return null;
        Calendar rtrn = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            rtrn.setTime(df.parse(parameter.trim()));
        } catch (ParseException e) {
            log.error(e);
            return null;
        }
        return rtrn;
    }

}
