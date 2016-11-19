package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.EngedelyEntity;

@Local
public interface EngedelyService {

	EngedelyEntity readAll();

	EngedelyEntity create(Long horgasztoId, Long halId, Date datum, int kor, int mennyiseg);

	EngedelyEntity update(Long horgasztoId, Long halId, Date datum, int kor, int mennyiseg);

	void delete(Long id);

}
