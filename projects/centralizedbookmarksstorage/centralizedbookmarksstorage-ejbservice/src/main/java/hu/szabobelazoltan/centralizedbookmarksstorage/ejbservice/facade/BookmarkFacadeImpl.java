package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;

import org.apache.log4j.Logger;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.BookmarkStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service.BookmarkService;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service.UserService;

public class BookmarkFacadeImpl implements BookmarkFacade {

	private static final Logger LOGGER = Logger.getLogger(BookmarkFacadeImpl.class);

	@EJB
	private BookmarkService bookmarkService;

	@EJB
	private UserService userService;

	@Override
	public List<BookmarkStub> getBookmarksByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookmarkStub> getBookmarksByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookmarkStub getBookmarkByShare() {
		// TODO Auto-generated method stub
		return null;
	}

}
