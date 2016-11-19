package hu.gyigorpeter.anglerregistry.persistence.service;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.HorgasztoEntity;

@Local
public interface HorgasztoService {

	HorgasztoEntity readAll();

	HorgasztoEntity create(String vizetKod, int terulet, String to_tipusa, int legnagyobbVizmelyseg, String tulajdonos, boolean horgaszTanya);

	HorgasztoEntity update(String vizetKod, int terulet, String to_tipusa, int legnagyobbVizmelyseg, String tulajdonos, boolean horgaszTanya);

	void delete(Long id);
}
