package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.Keyword;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;

@Local
public interface KeywordService {
	Keyword read(String keyword) throws PersistanceServiceException;

	List<Keyword> readAll() throws PersistanceServiceException;
}
