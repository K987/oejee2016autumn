package hu.gyigorpeter.anglerregistry.ejbservice.converter;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Horgasz;
import hu.gyigorpeter.anglerregistry.persistence.entity.HorgaszEntity;

@Stateless
public class HorgaszConverterImpl implements HorgaszConverter {

	@Override
	public Horgasz to(HorgaszEntity horgaszEntity) {
		Horgasz horgasz = null;
		if (horgaszEntity != null) {
			horgasz = new Horgasz(horgaszEntity.getNev(), horgaszEntity.getAnyjaNeve(), horgaszEntity.getSzuletesiIdo(), horgaszEntity.getSzuletesiHely(),
					horgaszEntity.getIrsz(), horgaszEntity.getVaros(), horgaszEntity.getCim(), horgaszEntity.getTarsadalmiMunka(), horgaszEntity.getEltiltas(),
					horgaszEntity.isTagE(), horgaszEntity.isTitkarsagiTagE());
		}
		return horgasz;
	}

	@Override
	public List<Horgasz> to(List<HorgaszEntity> horgaszEntityList) {
		List<Horgasz> horgaszList = new ArrayList<Horgasz>();

		if (horgaszEntityList != null && horgaszEntityList.size() != 0) {
			for (HorgaszEntity horgaszEntity : horgaszEntityList) {
				horgaszList.add(this.to(horgaszEntity));
			}
		}

		return horgaszList;
	}

}
