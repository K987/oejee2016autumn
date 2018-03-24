package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.facade.FinanceFacadeLocal;
import hun.restoffice.ejbservice.facade.PartnerFacadeLocal;
import hun.restoffice.remoteClient.domain.DocTypeStub;
import hun.restoffice.remoteClient.domain.IncomeStub;
import hun.restoffice.remoteClient.domain.PaymentMethodStub;
import hun.restoffice.remoteClient.exception.FacadeException;
import hun.restoffice.weblayer.util.FinanceHelperLocal;

/**
 *
 */
@WebServlet("/EmployeeEdit")
public class EmployeeEditServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(EmployeeEditServlet.class);

    @EJB
    private FinanceFacadeLocal fFacade;

    @EJB
    private FinanceHelperLocal fHelper;

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
        log.info("EmployeeEditServlet#doGet invoked");

        Integer employeeId = Integer.parseInt(request.getParameter("employeeId"));
        if (employeeId == -1) {

        } else if (employeeId != null) {

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Employee");
            dispatcher.forward(request, response);
        }


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
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        log.info("IncomeEditServlet#doPost invoked");

        request.setCharacterEncoding("UTF-8");

        String docId = request.getParameter("docId");
        DocTypeStub docType = DocTypeStub.values()[Integer.parseInt(request.getParameter("docType"))];
        String partner = null;
        try {
            partner = pFacade.getPartnerById(Integer.parseInt(request.getParameter("partner"))).getName();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FacadeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BigDecimal grossTotal = new BigDecimal(request.getParameter("grossTotal"));
        String description = request.getParameter("description");
        Calendar issue = formatCalendar(request.getParameter("issueDate"));
        PaymentMethodStub payMethod = PaymentMethodStub.values()[Integer.parseInt(request.getParameter("payMethod"))];
        Calendar expiry = formatCalendar(request.getParameter("expiryDate"));
        Calendar payed = formatCalendar(request.getParameter("payedDate"));
        String incomeType = request.getParameter("incomeType");
        Calendar accPerStart = formatCalendar(request.getParameter("accStartDate"));
        Calendar accPerEnd = formatCalendar(request.getParameter("accEndDate"));
        String isNew = request.getParameter("isNew");

        IncomeStub stub = new IncomeStub(docId, docType, partner, description, grossTotal, payMethod, incomeType, issue,
                payed, expiry, accPerStart, accPerEnd);
        log.info("income stub: " + stub);
        log.info("Input is: " + stub);
        try {
            if ("-1".equals(isNew.trim()))
                fFacade.addIncome(stub);
            else
                fFacade.updateIncome(stub);
        } catch (FacadeException e) {
            log.error(e);
        }

        response.sendRedirect("Income");
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
