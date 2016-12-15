package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.KeywordStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Keyword;

@Local
public interface KeywordConverter {
	KeywordStub to(Keyword keyword);
	
	List<KeywordStub> to(List<Keyword> results);
}
