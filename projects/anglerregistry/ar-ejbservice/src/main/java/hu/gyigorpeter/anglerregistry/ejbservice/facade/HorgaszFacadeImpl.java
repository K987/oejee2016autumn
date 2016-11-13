package hu.gyigorpeter.anglerregistry.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.ejbservice.converter.HorgaszConverter;
import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Horgasz;
import hu.gyigorpeter.anglerregistry.persistence.service.HorgaszService;

@Stateless
public class HorgaszFacadeImpl implements HorgaszFacade {

	@EJB
	private HorgaszService horgaszService;

	@EJB
	private HorgaszConverter horgaszConverter;

	@Override
	public Horgasz getHorgaszById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Horgasz getHorgaszByAllamijegy(Long allamiJegyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Horgasz> getAllHorgasz() {
		List<Horgasz> horgaszList = new ArrayList<Horgasz>();

		horgaszList = this.horgaszConverter.to(this.horgaszService.readAll());

		return horgaszList;
	}

}
