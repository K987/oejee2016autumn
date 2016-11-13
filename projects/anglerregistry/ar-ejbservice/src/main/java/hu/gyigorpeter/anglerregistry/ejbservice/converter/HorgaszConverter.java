package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Horgasz;
import hu.gyigorpeter.anglerregistry.persistence.entity.HorgaszEntity;

@Local
public interface HorgaszConverter {

	Horgasz to(HorgaszEntity horgaszEntity);

	List<Horgasz> to(List<HorgaszEntity> horgaszEntityList);

}
