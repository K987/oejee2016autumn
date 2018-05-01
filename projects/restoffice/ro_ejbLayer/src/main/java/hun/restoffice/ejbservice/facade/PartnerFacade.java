/**
 *
 */
package hun.restoffice.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.ejbservice.converter.PartnerConverterLocal;
import hun.restoffice.ejbservice.domain.PartnerContactStub;
import hun.restoffice.ejbservice.domain.PartnerStub;
import hun.restoffice.ejbservice.exception.AdaptorException;
import hun.restoffice.ejbservice.exception.ApplicationError;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;
import hun.restoffice.persistence.service.PartnerServiceLocal;
import hun.restoffice.remoteClient.exception.FacadeException;

/**
 * Partner business facade
 *
 * @author kalmankostenszky
 *
 */
@Stateless(mappedName = "ejb/partnerFacade")
public class PartnerFacade implements PartnerFacadeLocal {

    private static final Logger log = Logger.getLogger(PartnerFacade.class);

    @EJB
    private PartnerServiceLocal pService;

    @EJB
    private PartnerConverterLocal pConverter;

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#getPartnerContact( java.lang.String)
     */
    @Override
    public PartnerContactStub getPartnerContact(final String partnerName) throws AdaptorException {
        try {
            if (log.isDebugEnabled())
                log.debug("getPartnerContact invoked w/ param " + partnerName);
            final PartnerContactStub rtrn = pConverter.toContact(pService.read(partnerName));
            return rtrn;
        } catch (final PersistenceServiceException e) {
            log.error(e.getLocalizedMessage());
            if (e.getType().equals(PersistenceExceptionType.NOT_EXISTS)) {
                throw new AdaptorException(ApplicationError.NOT_EXISTS, e.getMessage());
            } else if (e.getType().equals(PersistenceExceptionType.AMBIGOUS_RESULT)) {
                throw new AdaptorException(ApplicationError.UNEXPECTED_RESULT, e.getMessage());
            } else {
                throw new AdaptorException(ApplicationError.UNEXPECTED, "Unexpeted error occured during execution. Param: " + partnerName);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#gatAllPartnerContact( )
     */
    @Override
    public List<PartnerStub> gatAllPartnerContact() throws AdaptorException {
        try {
            if (log.isDebugEnabled())
                log.debug("getAllPartnerContact invoked");
            final List<PartnerStub> rtrn = pConverter.toContact(pService.readAll(false));
            return rtrn;
        } catch (final PersistenceServiceException e) {
            log.error(e.getLocalizedMessage());
            throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#deleteUnusedPartners( )
     */
    @Override
    public List<PartnerStub> deleteUnusedPartners() throws AdaptorException {
        try {
            if (log.isDebugEnabled())
                log.debug("deleteUnusedPartners invoked");
            final List<PartnerStub> rtrn = pConverter.toPartner(pService.deleteUnused());
            return rtrn;
        } catch (PersistenceServiceException e) {
            log.error(e.getLocalizedMessage());
            // TODO:delete exception
            throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#addPartner(hun.
     * restoffice.ejbservice.domain.PartnerStub)
     */
    @Override
    public PartnerStub addPartner(final PartnerStub partner) throws AdaptorException {
        try {
            if (log.isDebugEnabled())
                log.debug("addPartner invoked w/ param: " + partner);
            return pConverter.toPartner(pService.create(pConverter.fromPartner(partner)));
        } catch (PersistenceServiceException e) {
            log.error(e.getLocalizedMessage());
            if (e.getType().equals(PersistenceExceptionType.EXISTS_ALREADY))
                throw new AdaptorException(ApplicationError.EXISTS_ALREADY, e.getMessage());
            else
                throw new AdaptorException(ApplicationError.UNEXPECTED, e.getMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#updatePartner(hun.
     * restoffice.ejbservice.domain.PartnerStub)
     */
    @Override
    public PartnerStub updatePartner(final PartnerStub partner) throws AdaptorException {
        try {
            if (log.isDebugEnabled())
                log.debug("updatePartner invoked w/ param: " + partner);
            return pConverter.toPartner(pService.update(pConverter.fromPartner(partner)));
        } catch (PersistenceServiceException e) {
            log.error(e.getLocalizedMessage());
            if (e.getType().equals(PersistenceExceptionType.NOT_EXISTS)) {
                throw new AdaptorException(ApplicationError.NOT_EXISTS, e.getMessage());
            } else if (e.getType().equals(PersistenceExceptionType.AMBIGOUS_RESULT)) {
                throw new AdaptorException(ApplicationError.UNEXPECTED_RESULT, e.getMessage());
            } else {
                throw new AdaptorException(ApplicationError.UNEXPECTED, "Unexpeted error occured during execution. Param: " + partner);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#gatAllPartner()
     */
    @Override
    public List<PartnerStub> gatAllPartner(final Boolean technical) throws FacadeException {
        List<PartnerStub> rtrn = new ArrayList<>();
        try {
            rtrn = pConverter.toPartner(pService.readAll(technical));
            return rtrn;
        } catch (PersistenceServiceException e) {
            log.error(e);
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.facade.PartnerFacadeLocal#getPartnerById(java.lang.String)
     */
    @Override
    public PartnerStub getPartnerById(final Integer id) throws FacadeException {
        try {
            return pConverter.toPartner(pService.readById(id));
        } catch (PersistenceServiceException e) {
            log.error(e.getLocalizedMessage());
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.facade.PartnerFacadeLocal#deletePatner(java.lang.
     * Integer)
     */
    @Override
    public void deletePatner(final Integer partnerId) throws FacadeException {
        try {
            pService.delete(partnerId);
        } catch (PersistenceServiceException e) {
            log.error(e.getLocalizedMessage());
            throw new FacadeException(e.getLocalizedMessage());
        }
    }

}
