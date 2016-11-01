package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.KeywordStub;

public interface KeywordFacade {
	List<KeywordStub> getAllKeywords();
}
