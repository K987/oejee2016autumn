package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.BookmarkStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.exception.AdaptorException;

@Local
public interface BookmarkFacade {
	List<BookmarkStub> getBookmarksByUsername(String username) throws AdaptorException;

	List<BookmarkStub> getBookmarksByKeyword(String keyword) throws AdaptorException;
}
