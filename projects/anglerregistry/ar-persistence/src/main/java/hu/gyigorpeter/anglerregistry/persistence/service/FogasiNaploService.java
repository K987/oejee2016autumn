package hu.gyigorpeter.anglerregistry.persistence.service;

import java.sql.Timestamp;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.FogasiNaploEntity;

@Local
public interface FogasiNaploService {
	FogasiNaploEntity readAll();

	FogasiNaploEntity create(Long engedelyId, Long horgasztoId, Long halId, Timestamp idopont, int mennyiseg);

	FogasiNaploEntity update(Long engedelyId, Long horgasztoId, Long halId, Timestamp idopont, int mennyiseg);

	void delete(Long id);

}
