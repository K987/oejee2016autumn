package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.KeywordStub;

@Local
public interface KeywordFacade {
	List<KeywordStub> getAllKeywords();
}
