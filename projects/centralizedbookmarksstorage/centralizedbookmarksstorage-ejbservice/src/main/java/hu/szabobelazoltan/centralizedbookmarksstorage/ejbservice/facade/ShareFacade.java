package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.ShareStub;

public interface ShareFacade {
	List<ShareStub> getAllShares();

	ShareStub getShareByBookmark();
}
