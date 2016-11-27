/**
 * 
 */
package hun.restoffice.persistence.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.inject.AmbiguousResolutionException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hun.restoffice.persistence.entity.dailyTransaction.Register;
import hun.restoffice.persistence.entity.dailyTransaction.RegisterClose;
import hun.restoffice.persistence.exception.PersistenceExceptionType;
import hun.restoffice.persistence.exception.PersistenceServiceException;

/**
 * @author hunkak
 *
 */
@Stateless(mappedName="ejb/registerService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RegisterService implements RegisterServiceLocal {

	
	private static final Logger LOG = Logger.getLogger(RegisterService.class);

	@PersistenceContext(unitName = "ro-persistence-unit")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.RegisterServiceLocal#readRegisterClose(java.util.Calendar)
	 */
	@Override
	public List<RegisterClose> readRegisterClose(Calendar day) throws PersistenceServiceException {
		try{
			List<RegisterClose> rtrn = this.entityManager.createNamedQuery(RegisterClose.FIND_REGISTER_CLOSE, RegisterClose.class).setParameter(RegisterClose.DAY, day.getTime()).getResultList();
			return rtrn;
		} catch (Exception e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.RegisterServiceLocal#readAllWithLastClose()
	 */
	@Override
	public List<RegisterClose> readAllWithLastClose() throws PersistenceServiceException {
		try {
			List<RegisterClose> rtrn = this.entityManager.createNamedQuery(RegisterClose.FIND_LAST_CLOSE, RegisterClose.class).getResultList();
			return rtrn;
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.RegisterServiceLocal#getRegisterWithId(java.lang.String)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Register readRegisterWithId(String id) throws PersistenceServiceException{
		try {
			return this.entityManager.createNamedQuery(Register.READ_BY_ID, Register.class).setParameter(Register.ID, id.trim().toLowerCase()).getSingleResult();
		} catch (AmbiguousResolutionException e) {
			LOG.error(e.getMessage());
			throw new PersistenceServiceException(PersistenceExceptionType.AMBIGOUS_RESULT, "multiple matching for id: " + id);
		} catch (NoResultException e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.NOT_EXISTS, "no matching for id: " + id);
		} catch (Exception e) {
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, e.getLocalizedMessage());
		}
	}

	/* (non-Javadoc)
	 * @see hun.restoffice.persistence.service.RegisterServiceLocal#createRegisterClose(java.lang.String, java.util.Date, int, double)
	 */
	@Override
	public void createRegisterClose(String id, Date time, int closeNo, double amt) throws PersistenceServiceException {
		Register register = readRegisterWithId(id);
		RegisterClose toAdd = new RegisterClose(register, closeNo, time, new BigDecimal(amt));
		toAdd.setRegister(register);
		try{
		this.entityManager.persist(toAdd);
		} catch(EntityExistsException e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.EXISTS_ALREADY, "Register close exists w id ["+id+", "+closeNo +"]");
		} catch(Exception e){
			LOG.error(e);
			throw new PersistenceServiceException(PersistenceExceptionType.UNKNOWN, "Unexpected error during register closing");
		}
		
	}

}
