package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.ShareStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.exception.AdaptorException;

@Local
public interface ShareFacade {
	List<ShareStub> getSharesByDate(Date date) throws AdaptorException;

	List<ShareStub> getShareByKeyword(String keyword) throws AdaptorException;

}
