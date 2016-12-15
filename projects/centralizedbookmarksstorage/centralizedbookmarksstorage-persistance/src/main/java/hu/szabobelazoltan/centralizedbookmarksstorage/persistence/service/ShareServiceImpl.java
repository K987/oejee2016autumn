package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Share;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.parameter.BookmarkParameter;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.query.BookmarkQuery;

@Stateless(mappedName = "ejb/shareServcie")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ShareServiceImpl implements ShareService {

	private final Logger LOGGER = Logger.getLogger(KeywordServiceImpl.class);

	@PersistenceContext(unitName = "centralizedbookmarksstorage-persistance-unit")
	private EntityManager entityManager;

	@Override
	public Share read(long bookmarkid) throws PersistanceServiceException {
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.info("Reading share by bookmark id.");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.SHARE_BY_BOOKMARK_ID, Share.class).setParameter(BookmarkParameter.BOOKMARK_ID, bookmarkid)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading share by bookmark id (" + bookmarkid + ")!", e);
		}
	}

	@Override
	public List<Share> readAll(Date date) throws PersistanceServiceException {
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.info("Reading shares by date (" + date + ").");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.SHARE_BY_DATE, Share.class).getResultList();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading shares by date (" + date + ")!", e);
		}
	}

	@Override
	public List<Share> readAll(String keyword) throws PersistanceServiceException {
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.info("Reading shares by keyword (" + keyword + ").");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.SHARE_BY_KEYWORD, Share.class).getResultList();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading shares by keyword (" + keyword + ")!", e);
		}
	}

}
