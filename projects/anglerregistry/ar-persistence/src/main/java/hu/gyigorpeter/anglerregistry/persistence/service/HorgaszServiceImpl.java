package hu.gyigorpeter.anglerregistry.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import hu.gyigorpeter.anglerregistry.persistence.entity.HorgaszEntity;

@Stateless
@Transactional
public class HorgaszServiceImpl implements HorgaszService {

	@PersistenceContext(unitName = "ar-persistence-unit")
	private EntityManager entityManager;

	@Override
	public HorgaszEntity readById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HorgaszEntity readByAllamiJegyId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HorgaszEntity> readAll() {
		// List<HorgaszEntity> horgaszEntityList = null;

		try {
			return this.entityManager.createNamedQuery("HorgaszEntity.GET_ALL", HorgaszEntity.class).getResultList();
		} catch (Exception e) {
			return null;
		}

	}

}
