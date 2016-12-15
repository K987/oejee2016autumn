package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Share;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;

@Local
public interface ShareService {
	Share read(long bookmarkid) throws PersistanceServiceException;

	List<Share> readAll(Date date) throws PersistanceServiceException;

	List<Share> readAll(String keyword) throws PersistanceServiceException;
}
