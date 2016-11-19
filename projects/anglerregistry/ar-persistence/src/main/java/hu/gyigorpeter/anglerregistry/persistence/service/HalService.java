package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.HalEntity;

@Local
public interface HalService {

	HalEntity readAll();

	HalEntity create(String halNev, int minimumMeret, int napidarabSzam, Date tilalmiIdoszakKezdete, Date tilalmiIdoszakVege, int puszulas);

	HalEntity update(String halNev, int minimumMeret, int napidarabSzam, Date tilalmiIdoszakKezdete, Date tilalmiIdoszakVege, int puszulas);

	void delete(Long id);

}
