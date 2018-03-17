/**
 *
 */
package hun.restoffice.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.ExpenseConverterLocal;
import hun.restoffice.ejbservice.converter.FinanceMiscConverterLocal;
import hun.restoffice.ejbservice.converter.IncomeConverterLocal;
import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.ejbservice.domain.ExpenseTypeStub;
import hun.restoffice.ejbservice.domain.IncomeTypeStub;
import hun.restoffice.persistence.entity.financialTransaction.PaymentMethod;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.ExpenseServiceLocal;
import hun.restoffice.persistence.service.FinanceMiscServiceLocal;
import hun.restoffice.persistence.service.IncomeServiceLocal;
import hun.restoffice.remoteClient.domain.IncomeStub;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 *
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName="ejb/financeFacade")
public class FinanceFacade implements FinanceFacadeLocal {

    private static final Logger log = Logger.getLogger(FinanceFacade.class);

    @EJB
    private ExpenseConverterLocal eConverter;

    @EJB
    private ExpenseServiceLocal eService;

    @EJB
    private FinanceMiscServiceLocal fmService;

    @EJB
    private FinanceMiscConverterLocal fmConverter;

    @EJB
    private IncomeConverterLocal iConverter;

    @EJB
    private IncomeServiceLocal iService;




    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.ExpenseFacadeLocal#getAllExpenses()
     */
    @Override
    public List<ExpenseStub> getAllExpenses()  throws FacadeException {
        List<ExpenseStub> rtrn = new ArrayList<>();
        try {
            rtrn = eConverter.to(eService.readAll());
            return rtrn;
        } catch (PersistenceServiceException e) {
            throw new FacadeException(e.getLocalizedMessage());
        }

    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.ExpenseFacadeLocal#deleteExpense(java.lang.String)
     */
    @Override
    public void deleteExpense(final String docId) throws FacadeException {
        try {
            eService.deleteExpense(docId);
        } catch (PersistenceServiceException e) {
            log.error(e);
            throw new FacadeException(e.getMessage());
        }

    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#getAllCostCenters()
     */
    @Override
    public List<CostCenterStub> getAllCostCenters() throws FacadeException {
        List<CostCenterStub> rtrn = new ArrayList<>();
        try{
            rtrn = fmConverter.toCostCenterStub(fmService.readAllCostCenter());
            return rtrn;
        } catch (PersistenceServiceException e){
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#getAllExpenseType()
     */
    @Override
    public List<ExpenseTypeStub> getAllExpenseType() throws FacadeException {
        List<ExpenseTypeStub> rtrn = new ArrayList<>();
        try{
            rtrn = fmConverter.toExpenseTypeStub(fmService.readAllExpenseType());
            return rtrn;
        } catch (PersistenceServiceException e){
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#getExpensesMatching(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean)
     */
    @Override
    public List<ExpenseStub> getExpensesMatching(final Integer partnerId, final Integer costCenterId, final Integer costTypeId, final Integer paymentMethodOrdinal, final Boolean isPayed)
            throws FacadeException {
        log.info("get Expense matching invoked");
        List<ExpenseStub> rtrn = new ArrayList<>();
        PaymentMethod pm = paymentMethodOrdinal == -1 ? null : PaymentMethod.values()[paymentMethodOrdinal];

        try{
            rtrn = eConverter.to(eService.readFiltered(partnerId, costCenterId, costTypeId, pm, isPayed));
            return rtrn;
        } catch (PersistenceServiceException e){
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#getExpenseById(java.lang.String)
     */
    @Override
    public ExpenseStub getExpenseById(final String docId) throws FacadeException {
        try{
            return eConverter.to(eService.readById(docId));
        } catch (PersistenceServiceException e){
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#addExpense(hun.restoffice.ejbservice.domain.ExpenseStub)
     */
    @Override
    public void addExpense(final ExpenseStub stub) throws FacadeException {
        try{
            eService.add(eConverter.from(stub));
        } catch (PersistenceServiceException e){
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }

    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#addIncome(hun.restoffice.remoteClient.domain.IncomeStub)
     */
    @Override
    public void addIncome(final IncomeStub stub) throws FacadeException {
        try{
            iService.insert(iConverter.from(stub));
        }catch (PersistenceServiceException e) {
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }

    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#updateExpense(hun.restoffice.ejbservice.domain.ExpenseStub)
     */
    @Override
    public void updateExpense(final ExpenseStub stub) throws FacadeException {
        try{
            eService.update(eConverter.from(stub));
        } catch (PersistenceServiceException e){
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }

    }
    /* (non-Javadoc)
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#getAllIncomes()
     */
    @Override
    public List<IncomeStub> getAllIncomes() throws FacadeException {
        List<IncomeStub> rtrn = new ArrayList<>();
        try {
            rtrn = iConverter.to(iService.readAll());
            return rtrn;
        } catch (PersistenceServiceException e) {
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.FinanceFacadeLocal#getAllIncomeType()
     */
    @Override
    public List<IncomeTypeStub> getAllIncomeType() throws FacadeException {
        List<IncomeTypeStub> rtrn = new ArrayList<>();
        try {
            rtrn = fmConverter.to(fmService.readAllIncomeTypes());
            return rtrn;
        } catch (PersistenceServiceException e) {
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.facade.FinanceFacadeLocal#getIncomeMatching(java.
     * lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean)
     */
    @Override
    public List<IncomeStub> getIncomeMatching(final Integer partnerId, final Integer incomeTypeId,
            final Integer paymentMethodOrdinal, final Boolean isPayed) throws FacadeException {
        log.info("get Income matching invoked");
        List<IncomeStub> rtrn = new ArrayList<>();
        PaymentMethod pm = paymentMethodOrdinal == -1 ? null : PaymentMethod.values()[paymentMethodOrdinal];

        try {
            rtrn = iConverter.to(iService.readFiltered(partnerId, incomeTypeId, pm, isPayed));
            return rtrn;
        } catch (PersistenceServiceException e) {
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }



}
