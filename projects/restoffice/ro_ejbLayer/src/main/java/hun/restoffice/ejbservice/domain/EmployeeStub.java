/**
 *
 */
package hun.restoffice.ejbservice.domain;

import java.math.BigDecimal;

import hun.restoffice.persistence.entity.employee.Employee;
import hun.restoffice.persistence.entity.employee.JobPosition;

/**
 * DTO for employee
 *
 * @author kalmankostenszky
 */
public class EmployeeStub {

    private Integer id;
    private String name;
    private JobPosition position;
    private BigDecimal wage;
    private Boolean active;

    public EmployeeStub(){

    }

    public EmployeeStub(final Employee emp) {
        id = emp.getId();
        name = emp.getEmployeeName();
        position = emp.getDefaultPosition();
        wage = emp.getDefaultHourlyWage();
        active = emp.IsActive();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the position
     */
    public JobPosition getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(final JobPosition position) {
        this.position = position;
    }

    /**
     * @return the wage
     */
    public BigDecimal getWage() {
        return wage;
    }

    /**
     * @param wage the wage to set
     */
    public void setWage(final BigDecimal wage) {
        this.wage = wage;
    }

    /**
     * @return the active
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(final Boolean active) {
        this.active = active;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("EmployeeStub [name=%s, position=%s, wage=%s, active=%s]", name, position, wage, active);
    }



}
