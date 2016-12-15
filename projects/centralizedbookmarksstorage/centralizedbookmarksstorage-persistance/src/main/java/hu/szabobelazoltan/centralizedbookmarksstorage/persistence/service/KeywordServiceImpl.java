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

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Keyword;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.parameter.BookmarkParameter;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.query.BookmarkQuery;

@Stateless(mappedName = "ejb/keywordService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class KeywordServiceImpl implements KeywordService {

	private final Logger LOGGER = Logger.getLogger(KeywordServiceImpl.class);

	@PersistenceContext(unitName = "centralizedbookmarksstorage-persistance-unit")
	private EntityManager entityManager;

	@Override
	public List<Keyword> readAll() throws PersistanceServiceException {
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.info("Reading all keywords.");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.KEYWORD_ALL, Keyword.class).getResultList();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading all keywords!", e);
		}
	}

	@Override
	public Keyword read(String keyword) throws PersistanceServiceException {
		if (this.LOGGER.isDebugEnabled()) {
			this.LOGGER.info("Reading all keywords.");
		}
		try {
			return this.entityManager.createNamedQuery(BookmarkQuery.KEYWORD_BY_KW, Keyword.class).setParameter(BookmarkParameter.KEYWORD, keyword)
					.getSingleResult();
		} catch (final Exception e) {
			throw new PersistanceServiceException("Unknown error at reading all keywords!", e);
		}
	}

}
