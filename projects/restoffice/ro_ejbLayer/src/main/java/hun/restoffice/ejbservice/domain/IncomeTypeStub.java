package hun.restoffice.ejbservice.domain;

/**
 *
 */
public class IncomeTypeStub {

    private Integer id;
    private String name;
    private Boolean prodRelated;

    /**
     * @param id
     * @param name
     * @param prodRelated
     */
    public IncomeTypeStub(final Integer id, final String name, final Boolean prodRelated) {
        this.id = id;
        this.name = name;
        this.prodRelated = prodRelated;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the prodRelated
     */
    public Boolean getProdRelated() {
        return prodRelated;
    }

    /**
     * @param prodRelated
     *            the prodRelated to set
     */
    public void setProdRelated(final Boolean prodRelated) {
        this.prodRelated = prodRelated;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "IncomeTypeStub [id=" + id + ", name=" + name + ", prodRelated=" + prodRelated + "]";
    }

}
