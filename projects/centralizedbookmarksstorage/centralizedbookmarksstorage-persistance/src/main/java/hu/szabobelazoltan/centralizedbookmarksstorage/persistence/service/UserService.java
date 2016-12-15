package hu.szabobelazoltan.centralizedbookmarksstorage.persistence.service;

import javax.ejb.Local;

import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.entity.User;
import hu.szabobelazoltan.centralizedbookmarksstorage.persistence.exception.PersistanceServiceException;

@Local
public interface UserService {
	User read(String username) throws PersistanceServiceException;
}
