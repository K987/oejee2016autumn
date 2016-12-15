package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.KeywordStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Keyword;

@Stateless
public class KeywordConverterImpl implements KeywordConverter {

	@Override
	public KeywordStub to(Keyword keyword) {
		KeywordStub stub = null;		
		if (keyword != null) {
			stub = new KeywordStub(keyword.getKeyword());
		}		
		return stub;
	}

	@Override
	public List<KeywordStub> to(List<Keyword> results) {
		final List<KeywordStub> stublist = new ArrayList<>();
		for (final Keyword keyword : results) {
			stublist.add(this.to(keyword));
		}
		return stublist;
	}

}
