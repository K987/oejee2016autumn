package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.persistence.entity.HorgaszEntity;

@Local
public interface HorgaszService {

	HorgaszEntity readById(Long id);

	HorgaszEntity readByAllamiJegyId(Long id);

	List<HorgaszEntity> readAll();

}
