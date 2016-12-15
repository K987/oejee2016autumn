package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Bookmark;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.parameter.BookmarkParameter;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.query.BookmarkQuery;

@Stateless(mappedName = "ejb/bookmarkService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BookmarkServiceImpl implements BookmarkService {

	private static final Logger LOGGER = Logger.getLogger(BookmarkServiceImpl.class);

	@PersistenceContext(unitName = "centralizedbookmarksstorage-persistance-unit")
	private EntityManager entityManager;

	@Override
	public List<Bookmark> readAll(long userid) throws PersistanceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.info("Reading bookmark by user id (" + String.valueOf(userid) + ")");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.BOOKMARK_BY_USER, Bookmark.class).setParameter(BookmarkParameter.BOOKMARK_USERID, userid)
					.getResultList();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading bookmark by user id (" + String.valueOf(userid) + ")!", e);
		}
	}

	@Override
	public List<Bookmark> readAll(String keyword) throws PersistanceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.info("Reading bookmark by keyword (" + keyword + ")");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.BOOKMARK_BY_KEYWORD, Bookmark.class).setParameter(BookmarkParameter.KEYWORD, keyword)
					.getResultList();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading bookmark by keyword (" + keyword + ")!", e);
		}
	}

	@Override
	public Bookmark read(long id) throws PersistanceServiceException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.info("Reading bookmark by id (" + String.valueOf(id) + ")");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.BOOKMARK_BY_ID, Bookmark.class).setParameter(BookmarkParameter.BOOKMARK_ID, id)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading bookmark by id (" + String.valueOf(id) + ")!", e);
		}
	}

}
