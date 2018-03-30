package hun.restoffice.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@WebServlet("/PartnerDelete")
public class PartnerDeleteServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(PartnerDeleteServlet.class);

    @EJB
    private PartnerFacadeLocal pFacade;

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
        log.info("PartnerDeleteServlet#doGet invoked");

        Integer partnerId = Integer.parseInt(request.getParameter("partnerId"));

        if (partnerId != null) {
            try {
                pFacade.deletePatner(partnerId);
            } catch (FacadeException e) {
                log.error(e);
            }

        }
        response.sendRedirect("Partner");
    }
}
