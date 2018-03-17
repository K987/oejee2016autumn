/**
 *
 */
package hun.restoffice.weblayer.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

import hun.restoffice.ejbservice.facade.FinanceFacadeLocal;
import hun.restoffice.remoteClient.domain.IncomeStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 *
 * @author kalmankostenszky
 */
@WebServlet("/Income")
public class IncomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(IncomeServlet.class);

    @EJB
    private FinanceFacadeLocal fFacade;


    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        log.info("Income#doGet() invoked");
        List<IncomeStub> incomes = getIncomes();

        request.setAttribute("incomes", incomes);

        this.forward(request, response);
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
        log.info("Income#doPost invoked");

        Integer partnerId = Integer.parseInt(request.getParameter("partner"));
        Integer incomeTypeId = Integer.parseInt(request.getParameter("incomeType"));
        Integer paymentMethodOrdinal = Integer.parseInt(request.getParameter("paymentMethod"));
        Boolean isPayed = request.getParameter("isPayed").equals("-1") ? null
                : request.getParameter("isPayed").equals("1");

        List<IncomeStub> incomes = getIncomes(partnerId, incomeTypeId, paymentMethodOrdinal, isPayed);
        log.info("result size is: " + incomes.size());
        request.setAttribute("incomes", incomes);

        this.forward(request, response);

    }

    /**
     * @param partnerId
     * @param incomeTypeId
     * @param paymentMethodOrdinal
     * @param isPayed
     * @return
     */
    private List<IncomeStub> getIncomes(final Integer partnerId, final Integer incomeTypeId,
            final Integer paymentMethodOrdinal, final Boolean isPayed) {
        log.info("IncomeList#getIncomes invoked");
        List<IncomeStub> stubs = new ArrayList<>();
        try {
            stubs = fFacade.getIncomeMatching(partnerId, incomeTypeId, paymentMethodOrdinal, isPayed);
            Collections.sort(stubs, new Comparator<IncomeStub>() {

                @Override
                public int compare(final IncomeStub o1, final IncomeStub o2) {
                    int rtrn = o1.getRegistered().getTime().compareTo(o2.getRegistered().getTime());
                    return rtrn;
                }
            });

        } catch (FacadeException e) {
            log.error(e);
        }
        return stubs;
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void forward(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher dispatcher = request.getRequestDispatcher("Income.jsp");
        dispatcher.forward(request, response);
    }


    /**
     * @return
     */
    private List<IncomeStub> getIncomes() {
        log.info("Income#getIncomes invoked");
        List<IncomeStub> stubs = new ArrayList<>();
        try {
            stubs = fFacade.getAllIncomes();
            Collections.sort(stubs, new Comparator<IncomeStub>() {

                @Override
                public int compare(final IncomeStub o1, final IncomeStub o2) {
                    int rtrn = o1.getRegistered().getTime().compareTo(o2.getRegistered().getTime());
                    return rtrn;
                }
            });

        } catch (FacadeException e) {
            log.error(e);
        }
        return stubs;
    }


}
