package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.facade;

import java.util.List;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.BookmarkStub;

public interface BookmarkFacade {
	List<BookmarkStub> getBookmarksByUsername(String username);

	List<BookmarkStub> getBookmarksByKeyword(String keyword);

	BookmarkStub getBookmarkByShare();
}
