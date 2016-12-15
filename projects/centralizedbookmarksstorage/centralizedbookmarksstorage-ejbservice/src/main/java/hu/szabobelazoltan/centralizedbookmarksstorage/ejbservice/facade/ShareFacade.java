package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.ShareStub;

@Local
public interface ShareFacade {
	List<ShareStub> getAllShares();

	ShareStub getShareByKeyword(String keyword);

	ShareStub getShareByBookmark(Long bookmarkid);
}
