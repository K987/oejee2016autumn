/**
 *
 */
package hun.restoffice.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.financialTransaction.IncType;
import hun.restoffice.persistence.entity.financialTransaction.Income;
import hun.restoffice.persistence.entity.financialTransaction.PaymentMethod;
import hun.restoffice.persistence.entity.partner.Partner;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 *
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/incomeService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class IncomeService implements IncomeServiceLocal {

    private static final Logger log = Logger.getLogger(IncomeService.class);

    @PersistenceContext(unitName = "ro-persistence-unit")
    private EntityManager entityManager;

    @EJB
    private PartnerServiceLocal pService;

    @EJB
    private FinanceMiscServiceLocal fmService;
    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.persistence.service.IncomeServiceLocal#add(hun.restoffice.persistence.entity.financialTransaction.
     * Income)
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Income insert(final Income income) throws PersistenceServiceException {
        if (this.count(income.getDocId()) == 0) {
            Partner partner = pService.read(income.getPartnerName());
            IncType incType = fmService.readIncTypeByName(income.getIncTypeName());
            income.setParty(partner);
            income.setIncType(incType);
            try{
                return entityManager.merge(income);
            } catch (Exception e){
                log.error(e);
                throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown exception occured while persisting income with docId: "+income.getDocId());
            }
        }
        else{
            throw new PersistenceServiceException(PersistenceExceptionType.EXISTS_ALREADY, "income already exists w/ docId: "+income.getDocId());
        }
    }

    /**
     * @param docId
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    private int count(final String docId) throws PersistenceServiceException {
        try {
            return entityManager.createNamedQuery(Income.COUNT_BY_ID, Long.class).setParameter(Income.ID, docId.trim().toLowerCase()).getSingleResult()
                    .intValue();
        } catch (Exception e) {
            log.error(e);
            throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "error while counting docId: " + docId);
        }

    }

    /* (non-Javadoc)
     * @see hun.restoffice.persistence.service.IncomeServiceLocal#insertAll(java.util.List)
     */
    @Override
    public List<Income> insertAll(final List<Income> incomes) throws PersistenceServiceException {
        List<Income> rtrn = new ArrayList<>();
        for (Income income : incomes) {
            rtrn.add(insert(income));
        }
        return rtrn;
    }

    /* (non-Javadoc)
     * @see hun.restoffice.persistence.service.IncomeServiceLocal#readAll()
     */
    @Override
    public List<Income> readAll() throws PersistenceServiceException {
        try{
            return entityManager.createNamedQuery(Income.FIND_ALL, Income.class).getResultList();
        } catch (Exception e){
            log.error(e);
            throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "unknown exception while retireving all incomes");
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.persistence.service.IncomeServiceLocal#readFiltered(java.lang.
     * Integer, java.lang.Integer,
     * hun.restoffice.persistence.entity.financialTransaction.PaymentMethod,
     * java.lang.Boolean)
     */
    @Override
    public List<Income> readFiltered(final Integer partnerId, final Integer incomeTypeId, final PaymentMethod pm,
            final Boolean isPayed) throws PersistenceServiceException {
        log.info("readFiltered invoked with params: [ partnerID: " + partnerId + ", " + ", " + "incomeTypeId: "
                + incomeTypeId + ", " + "PaymentMethod: " + pm + ", " + "isPayed: " + isPayed
                + "]");
        int payed = isPayed == null ? 0 : isPayed.booleanValue() == true ? 1 : -1;
        int payMethod = pm == null ? -1 : pm.ordinal();

        try {
            return entityManager.createNamedQuery(Income.READ_FILTERED, Income.class)
                    .setParameter(Income.PARTNER_ID, partnerId).setParameter(Income.INCOMETYPE_ID, incomeTypeId)
                    .setParameter(Income.PAYMENT_METHOD, payMethod).setParameter(Income.IS_PAYED, payed)
                    .getResultList();
        } catch (Exception e) {
            log.error(e);
            throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN,
                    "error occured while reading incomes");
        }
    }

}
