package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.ShareStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Share;

@Stateless
public class ShareConverterImpl implements ShareConverter {

	@Override
	public ShareStub to(Share share) {
		ShareStub stub = null;
		if (share != null) {
			stub = new ShareStub(share.getDate());
		}
		return stub;
	}

	@Override
	public List<ShareStub> to(List<Share> results) {
		final List<ShareStub> stublist = new ArrayList<>();
		for (Share share : results) {
			stublist.add(this.to(share));
		}
		return stublist;
	}

}
