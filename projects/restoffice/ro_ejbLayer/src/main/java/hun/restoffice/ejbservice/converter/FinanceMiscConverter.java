/**
 *
 */
package hun.restoffice.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hun.restoffice.ejbservice.domain.CostCenterStub;
import hun.restoffice.ejbservice.domain.ExpenseTypeStub;
import hun.restoffice.ejbservice.domain.IncomeTypeStub;
import hun.restoffice.persistence.entity.financialTransaction.CostCenter;
import hun.restoffice.persistence.entity.financialTransaction.ExpType;
import hun.restoffice.persistence.entity.financialTransaction.IncType;

/**
 *
 *
 * @author kalmankostenszky
 */
@Stateless
public class FinanceMiscConverter implements FinanceMiscConverterLocal {

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.converter.FinanceMiscConverterLocal#to(java.util.List)
     */
    @Override
    public List<CostCenterStub> toCostCenterStub(final List<CostCenter> costCenters) {

        List<CostCenterStub> rtrn = new ArrayList<>();
        for (CostCenter costCenter : costCenters) {
            rtrn.add(toCostCenterStub(costCenter));
        }
        return rtrn;
    }

    /**
     * @param costCenter
     * @return
     */
    private CostCenterStub toCostCenterStub(final CostCenter costCenter) {
        return new CostCenterStub(costCenter.getId(), costCenter.getName());
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.converter.FinanceMiscConverterLocal#toExpenseTypeStub(java.util.List)
     */
    @Override
    public List<ExpenseTypeStub> toExpenseTypeStub(final List<ExpType> expTypes) {
        List<ExpenseTypeStub> stubs = new ArrayList<>();

        for (ExpType expType : expTypes) {
            stubs.add(toExpenseTypeStub(expType));
        }
        return stubs;
    }

    /**
     * @param expType
     * @return
     */
    private ExpenseTypeStub toExpenseTypeStub(final ExpType expType) {
        return new ExpenseTypeStub(expType.getId(), expType.getName(), expType.getProdRelated());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.converter.FinanceMiscConverterLocal#to(java.util.
     * List)
     */
    @Override
    public List<IncomeTypeStub> to(final List<IncType> incTypes) {
        List<IncomeTypeStub> stubs = new ArrayList<>();

        for (IncType incomeType : incTypes) {
            stubs.add(to(incomeType));
        }

        return stubs;
    }

    /**
     * @param incomeType
     * @return
     */
    private IncomeTypeStub to(final IncType incomeType) {
        return new IncomeTypeStub(incomeType.getId(), incomeType.getName(), incomeType.getProdRelated());
    }

}
