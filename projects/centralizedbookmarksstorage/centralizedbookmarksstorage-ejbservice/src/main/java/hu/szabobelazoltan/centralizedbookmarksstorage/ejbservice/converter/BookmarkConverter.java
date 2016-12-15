package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.BookmarkStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Bookmark;

@Local
public interface BookmarkConverter {
	BookmarkStub to(Bookmark bookmark);
	
	List<BookmarkStub> to(List<Bookmark> results);
}
