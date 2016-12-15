package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.User;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.parameter.BookmarkParameter;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.query.BookmarkQuery;

@Stateless(mappedName = "ejb/userService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

	private final Logger LOGGER = Logger.getLogger(KeywordServiceImpl.class);

	@PersistenceContext(unitName = "centralizedbookmarksstorage-persistance-unit")
	private EntityManager entityManager;

	@Override
	public User read(String username) throws PersistanceServiceException {
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.info("Reading user by name (" + username + ").");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.USER_BY_NAME, User.class).setParameter(BookmarkParameter.USER_NAME, username)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading user by name (" + username + ")!", e);
		}
	}

}
