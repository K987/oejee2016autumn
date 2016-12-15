package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Bookmark;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;

@Local
public interface BookmarkService {
	Bookmark read(long id) throws PersistanceServiceException;

	List<Bookmark> readAll(long userid) throws PersistanceServiceException;

	List<Bookmark> readAll(String keyword) throws PersistanceServiceException;
}
