package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.FogasiNaplo;
import hu.gyigorpeter.anglerregistry.persistence.entity.FogasiNaploEntity;

@Local
public interface FogasiNaploConverter {

	FogasiNaplo to(FogasiNaploEntity fogasiNaploEntity);

	List<FogasiNaplo> to(List<FogasiNaploEntity> fogasiNaploEntityList);
}
