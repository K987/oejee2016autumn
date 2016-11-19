package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.Date;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.TelepitesEntity;

@Local
public interface TelepitesService {

	TelepitesEntity readAll();

	TelepitesEntity create(Long horgasztoId, Long halId, Date datum, int kor, int mennyiseg, int tilalmiNapokSzama);

	TelepitesEntity update(Long horgasztoId, Long halId, Date datum, int kor, int mennyiseg, int tilalmiNapokSzama);

	void delete(Long id);
}
