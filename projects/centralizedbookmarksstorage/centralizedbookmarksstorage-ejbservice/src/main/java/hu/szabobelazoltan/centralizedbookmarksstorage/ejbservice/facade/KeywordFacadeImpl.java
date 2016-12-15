package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter.KeywordConverter;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.KeywordStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.exception.AdaptorException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Keyword;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service.KeywordService;

@Stateless
public class KeywordFacadeImpl implements KeywordFacade {

	@EJB
	private KeywordService keywordService;
	
	@EJB
	private KeywordConverter converter;
	
	
	@Override
	public List<KeywordStub> getAllKeywords() throws AdaptorException {
		List<KeywordStub> stubs = new ArrayList<>();
		try {
			List<Keyword> results = keywordService.readAll();
			stubs = this.converter.to(results);
		} catch (final Exception e) {
			throw new AdaptorException("Unknown error!", e);
		}
		return stubs;
	}

}
