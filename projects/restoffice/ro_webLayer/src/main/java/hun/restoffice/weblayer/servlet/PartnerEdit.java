package hun.restoffice.weblayer.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 */
@WebServlet("/PartnerEdit")
public class PartnerEdit extends HttpServlet {

    private static final Logger log = Logger.getLogger(PartnerEdit.class);

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

        log.info("PartnerEdit#doGet invoked");

        Integer partnerId = Integer.parseInt(request.getParameter("partnerId"));
        PartnerStub partner = new PartnerStub(null, null, null);

        if (partnerId != null && partnerId != -1)
            try {
                partner = pFacade.getPartnerById(partnerId);
            } catch (FacadeException e) {
                log.error(e);
            }
        request.setAttribute("partner", partner);

        RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerEdit.jsp");
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
        log.info("PartnerEdit#doPost invoked");

        request.setCharacterEncoding("UTF-8");

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String accountno = request.getParameter("accountno");
        String contact = request.getParameter("contact");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        PartnerStub partner = new PartnerStub(name, accountno, new PartnerContactStub(contact, phone, email));

        if (id == -1) {
            try {
                pFacade.addPartner(partner);
            } catch (AdaptorException e) {
                log.error(e);
            }
        } else {
            try {
                pFacade.updatePartner(partner);
            } catch (AdaptorException e) {
                log.error(e);
            }
        }
    }
}
