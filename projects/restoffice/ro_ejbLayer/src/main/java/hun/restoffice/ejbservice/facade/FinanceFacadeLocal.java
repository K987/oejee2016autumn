/**
 *
 */
package hun.restoffice.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.ejbservice.domain.ExpenseStub;
import hun.restoffice.ejbservice.domain.ExpenseTypeStub;
import hun.restoffice.ejbservice.domain.IncomeTypeStub;
import hun.restoffice.remoteClient.domain.IncomeStub;
import hun.restoffice.remoteClient.exception.FacadeException;



/**
 *
 *
 * @author kalmankostenszky
 */
@Local
public interface FinanceFacadeLocal {


    /**
     * @return
     * @throws FacadeException
     */
    List<ExpenseStub> getAllExpenses() throws FacadeException;

    /**
     * @param docId
     * @throws FacadeException
     */
    void deleteExpense(String docId) throws FacadeException;

    /**
     * @return
     * @throws FacadeException
     */
    List<CostCenterStub> getAllCostCenters() throws FacadeException;


    /**
     * @return
     * @throws FacadeException
     */
    List<ExpenseTypeStub> getAllExpenseType() throws FacadeException;

    /**
     * @param partnerId
     * @param costCenterId
     * @param costTypeId
     * @param paymentMethodOrdinal
     * @param isPayed
     * @return
     * @throws FacadeException
     */
    List<ExpenseStub> getExpensesMatching(Integer partnerId, Integer costCenterId, Integer costTypeId, Integer paymentMethodOrdinal, Boolean isPayed) throws FacadeException;

    /**
     * @param docId
     * @return
     */
    ExpenseStub getExpenseById(String docId) throws FacadeException;


    /**
     * @param stub
     * @throws FacadeException
     */
    void addExpense(ExpenseStub stub) throws FacadeException;

    /**
     * @param stub
     * @throws FacadeException
     */
    void addIncome(IncomeStub stub) throws FacadeException;

    /**
     * @param stub
     */
    void updateExpense(ExpenseStub stub) throws FacadeException;

    /**
     * @return
     */
    List<IncomeStub> getAllIncomes() throws FacadeException;

    /**
     * @return
     */
    List<IncomeTypeStub> getAllIncomeType() throws FacadeException;

    /**
     * @param partnerId
     * @param incomeTypeId
     * @param paymentMethodOrdinal
     * @param isPayed
     * @return
     */
    List<IncomeStub> getIncomeMatching(Integer partnerId, Integer incomeTypeId, Integer paymentMethodOrdinal,
            Boolean isPayed) throws FacadeException;

    /**
     * @param docId
     * @return
     */
    IncomeStub getIncomeById(String docId) throws FacadeException;

    /**
     * @param stub
     */
    void updateIncome(IncomeStub stub) throws FacadeException;

    /**
     * @param docId
     */
    void deleteIncome(String docId) throws FacadeException;

}
