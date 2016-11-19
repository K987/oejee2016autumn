
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import hu.gyigorpeter.anglerregistry.ejbservice.facade.HorgaszFacade;
import hu.gyigorpeter.anglerregistry.ejbservice.pojo.Horgasz;

@ViewScoped
@Named("backingBean")
public class ManagementBean implements Serializable {

	private static final long serialVersionUID = -554423484774035995L;

	@EJB
	private HorgaszFacade horgaszFacade;

	private List<Horgasz> horgaszList = new ArrayList<Horgasz>();

	private boolean halViewFlag = false;
	private boolean horgaszViewFlag = false;
	private boolean horgasztoViewFlag = false;
	private boolean engedelyViewFlag = false;
	private boolean telepitesViewFlag = false;
	private boolean fogsiNaploViewFlag = false;

	@PostConstruct
	public void init() {
		horgaszList = horgaszFacade.getAllHorgasz();
	}

	public List<Horgasz> getHorgaszList() {
		return horgaszList;
	}

	public void setHorgaszList(List<Horgasz> horgaszList) {
		this.horgaszList = horgaszList;
	}

	public boolean isHalViewFlag() {
		return halViewFlag;
	}

	public void setHalViewFlag(boolean halViewFlag) {
		this.halViewFlag = halViewFlag;
	}

	public boolean isHorgaszViewFlag() {
		return horgaszViewFlag;
	}

	public void setHorgaszViewFlag(boolean horgaszViewFlag) {
		this.horgaszViewFlag = horgaszViewFlag;
	}

	public boolean isHorgasztoViewFlag() {
		return horgasztoViewFlag;
	}

	public void setHorgasztoViewFlag(boolean horgasztoViewFlag) {
		this.horgasztoViewFlag = horgasztoViewFlag;
	}

	public boolean isEngedelyViewFlag() {
		return engedelyViewFlag;
	}

	public void setEngedelyViewFlag(boolean engedelyViewFlag) {
		this.engedelyViewFlag = engedelyViewFlag;
	}

	public boolean isTelepitesViewFlag() {
		return telepitesViewFlag;
	}

	public void setTelepitesViewFlag(boolean telepitesViewFlag) {
		this.telepitesViewFlag = telepitesViewFlag;
	}

	public boolean isFogsiNaploViewFlag() {
		return fogsiNaploViewFlag;
	}

	public void setFogsiNaploViewFlag(boolean fogsiNaploViewFlag) {
		this.fogsiNaploViewFlag = fogsiNaploViewFlag;
	}

	public void viewButtonAction() {
		// for (int i = 0; i < viewFlag.length; i++) {
		// if (i == 1) {
		// viewFlag[i] = !viewFlag[i];
		// } else {
		// viewFlag[i] = false;
		// }
		// }
	}

	public void horgaszViewButtonActionListener() {
		horgasztoViewFlag = !horgaszViewFlag;
	}

}
