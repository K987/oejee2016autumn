package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Horgasz;

@Local
public interface HorgaszFacade {

	Horgasz getHorgaszById(Long id);

	Horgasz getHorgaszByAllamijegy(Long allamiJegyId);

	List<Horgasz> getAllHorgasz();

}
