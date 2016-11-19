package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Horgaszto;
import hu.gyigorpeter.anglerregistry.persistence.entity.HorgasztoEntity;

public interface HorgasztoConverter {

	Horgaszto to(HorgasztoEntity horgasztoEntity);

	List<Horgaszto> to(List<HorgasztoEntity> horgasztoEntityList);
}
