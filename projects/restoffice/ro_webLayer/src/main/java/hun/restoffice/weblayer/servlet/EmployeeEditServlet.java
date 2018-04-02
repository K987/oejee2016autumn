package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.EmployeeStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.facade.EmployeeFacadeLocal;
import hun.restoffice.persistence.entity.employee.JobPosition;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@WebServlet("/EmployeeEdit")
public class EmployeeEditServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(EmployeeEditServlet.class);

    @EJB
    private EmployeeFacadeLocal eFacade;

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

        request.getSession();
        log.info("EmployeeEditServlet#doGet invoked");

        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
        EmployeeStub employee = new EmployeeStub();
        employee.setId(-1);
        employee.setName("");
        employee.setPosition(JobPosition.BARTENDER);
        employee.setWage(new BigDecimal("0"));
        employee.setActive(true);
        if (employeeId != null && employeeId != -1) {
            try {
                employee = eFacade.getEmployee(employeeId);
            } catch (FacadeException e) {
                log.error("cant find employee");
            }
        }

        request.setAttribute("employee", employee);

        RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeEdit.jsp");
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
        log.info("EmployeeEditServlet#doPost invoked");

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        JobPosition jobPosition = JobPosition.values()[Integer.parseInt(request.getParameter("position"))];
        BigDecimal wage = new BigDecimal(request.getParameter("wage"));
        Boolean isActive = new Boolean(request.getParameter("isActive"));

        EmployeeStub emp = new EmployeeStub();
        emp.setName(name);
        emp.setPosition(jobPosition);
        emp.setWage(wage);
        emp.setActive(isActive);

        log.info(emp.toString());
        if (id != -1) {
            try {
                emp.setId(id);
                log.info("id is...." + id);
                eFacade.updateEmployee(emp);
            } catch (AdaptorException e) {
                log.error(e);
            }
        } else {
            try {
                eFacade.addEmployee(emp);
            } catch (AdaptorException e) {
                log.error(e);
            }
        }
        response.sendRedirect("Employee");
    }
}
