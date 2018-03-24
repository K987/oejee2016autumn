/**
 *
 */
package hun.restoffice.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.facade.FinanceFacadeLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 *
 * @author kalmankostenszky
 */
@WebServlet("/IncomeDelete")
public class IncomeDeleteServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(IncomeDeleteServlet.class);

    @EJB
    private FinanceFacadeLocal fFacade;

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        LOG.info("IncomeDelete#doGet() invoked");
        String docId = request.getParameter("docId");

        if (docId != null && !"".equalsIgnoreCase(docId.trim()))
            try {
                fFacade.deleteIncome(docId);
            } catch (FacadeException e) {
                LOG.error(e);
            }

        response.sendRedirect("Income");
    }

}
