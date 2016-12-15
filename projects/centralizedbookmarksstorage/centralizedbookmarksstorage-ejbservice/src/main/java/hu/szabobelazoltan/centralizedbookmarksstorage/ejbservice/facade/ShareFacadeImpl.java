package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter.ShareConverter;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.ShareStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.exception.AdaptorException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Share;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service.ShareService;

@Stateless
public class ShareFacadeImpl implements ShareFacade {

	@EJB
	private ShareService shareService;
	
	@EJB
	private ShareConverter converter;
	
	@Override
	public List<ShareStub> getShareByKeyword(String keyword) throws AdaptorException {
		List<ShareStub> stubs = new ArrayList<>();
		try {
			List<Share> results = this.shareService.readAll(keyword);
			stubs = this.converter.to(results);
		} catch (final Exception e) {
			throw new AdaptorException("Unknown error!", e);
		}
		return stubs;
	}

	@Override
	public List<ShareStub> getSharesByDate(Date date) throws AdaptorException {
		List<ShareStub> stubs = new ArrayList<>();
		try {
			List<Share> results = this.shareService.readAll(date);
			stubs = this.converter.to(results);
		} catch (final Exception e) {
			throw new AdaptorException("Unknown error!", e);
		}
		return stubs;
	}

}
