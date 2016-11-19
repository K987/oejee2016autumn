package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.List;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Telepites;
import hu.gyigorpeter.anglerregistry.persistence.entity.TelepitesEntity;

public interface TelepitesConverter {

	Telepites to(TelepitesEntity telepitesEntity);

	List<Telepites> to(List<TelepitesEntity> telepitesEntityList);
}
