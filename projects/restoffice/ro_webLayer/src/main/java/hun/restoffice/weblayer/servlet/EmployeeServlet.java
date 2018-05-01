package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

/**
 *
 */
@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(EmployeeServlet.class);

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

        log.info("EmployeeServlet doGet invoked");
        List<EmployeeStub> employees = new ArrayList<>();
        try {
            employees = eFacade.getAllEmployees();
            employees.sort(new Comparator<EmployeeStub>() {

                @Override
                public int compare(final EmployeeStub o1, final EmployeeStub o2) {
                    if (o1.isActive() && !o2.isActive()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        } catch (AdaptorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Employee.jsp");
        dispatcher.forward(request, response);
    }
}
