package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Engedely;
import hu.gyigorpeter.anglerregistry.persistence.entity.EngedelyEntity;

@Local
public interface EngedelyConverter {

	Engedely to(EngedelyEntity engedelyEntity);

	List<Engedely> to(List<EngedelyEntity> engedelyEntity);
}
