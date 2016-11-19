package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Hal;
import hu.gyigorpeter.anglerregistry.persistence.entity.HalEntity;

@Local
public interface HalConverter {

	Hal to(HalEntity halEntity);

	List<Hal> to(List<HalEntity> halEntityList);
}
