package hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.szabobelazoltan.centralizedbookmarksstorage.ejbservice.domain.BookmarkStub;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Bookmark;

@Stateless
public class BookmarkConverterImpl implements BookmarkConverter {

	@Override
	public BookmarkStub to(Bookmark bookmark) {
		BookmarkStub stub = null;
		
		if (bookmark != null) {
			stub = new BookmarkStub(
					bookmark.getTitle(), 
					bookmark.getUrl(), 
					bookmark.getDescription(),
					bookmark.getPreview());
		}
		
		return stub;
	}

	@Override
	public List<BookmarkStub> to(List<Bookmark> results) {
		final List<BookmarkStub> stublist = new ArrayList<>();
		
		for (final Bookmark bookmark : results) {
			stublist.add(this.to(bookmark));
		}
		
		return stublist;
	}

}
