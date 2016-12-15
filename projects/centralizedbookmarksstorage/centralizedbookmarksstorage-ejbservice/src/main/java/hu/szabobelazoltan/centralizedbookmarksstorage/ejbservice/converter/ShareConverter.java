package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.ShareStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Share;

@Local
public interface ShareConverter {
	ShareStub to(Share share);
	
	List<ShareStub> to(List<Share> results);
}
