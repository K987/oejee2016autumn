package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import org.apache.log4j.Logger;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter.BookmarkConverter;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.BookmarkStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.exception.AdaptorException;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Bookmark;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.User;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service.BookmarkService;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service.UserService;

public class BookmarkFacadeImpl implements BookmarkFacade {

	private static final Logger LOGGER = Logger.getLogger(BookmarkFacadeImpl.class);

	@EJB
	private BookmarkService bookmarkService;

	@EJB
	private UserService userService;

	@EJB
	private BookmarkConverter converter;
	
	@Override
	public List<BookmarkStub> getBookmarksByUsername(String username) throws AdaptorException {
		List<BookmarkStub> stubs = new ArrayList<>();
		try {
			User userresult = this.userService.read(username);
			List<Bookmark> results = this.bookmarkService.readAll(userresult.getId());
			
			stubs = converter.to(results); 
		} catch (Exception e) {
			throw new AdaptorException("Unknown error", e);
		}
		return stubs;
	}

	@Override
	public List<BookmarkStub> getBookmarksByKeyword(String keyword) throws AdaptorException {
		List<BookmarkStub> stubs = new ArrayList<>();
		try {
			List<Bookmark> results = this.bookmarkService.readAll(keyword);
			
			stubs = converter.to(results); 
		} catch (Exception e) {
			throw new AdaptorException("Unknown error", e);
		}
		return stubs;
	}

}
