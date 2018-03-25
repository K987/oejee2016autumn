package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@WebServlet("/Partner")
public class PartnerServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(PartnerServlet.class);

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
        log.info("PartnerServlet#doGet invoked");

        List<PartnerStub> partners = new ArrayList<>();
        try {
            partners = pFacade.gatAllPartner(false);
        } catch (FacadeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("partners", partners);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Partner.jsp");
        dispatcher.forward(request, response);

    }
}
