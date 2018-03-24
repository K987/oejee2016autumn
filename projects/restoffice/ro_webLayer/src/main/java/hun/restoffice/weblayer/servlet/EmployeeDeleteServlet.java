/**
 *
 */
package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.ShiftStub;
import hun.restoffice.ejbservice.facade.EmployeeFacadeLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 *
 * @author kalmankostenszky
 */
@WebServlet("/EmployeeDelete")
public class EmployeeDeleteServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(EmployeeDeleteServlet.class);

    @EJB
    private EmployeeFacadeLocal eFacade;

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        LOG.info("IncomeDelete#doGet() invoked");
        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));

        if (employeeId != null)
            try {
                // TODO: show deleted shifts
                List<ShiftStub> deletedShifts = eFacade.removeEmployee(employeeId);
            } catch (FacadeException e) {
                LOG.error(e);
            }

        response.sendRedirect("Employee");
    }

}
