
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

	private boolean[] viewFlag = new boolean[6];
	private int halViewFlag = 1;
	private int horgaszViewFlag = 2;
	private int horgasztoViewFlag = 3;
	private int engedelyViewFlag = 4;
	private int telepitesViewFlag = 5;
	private int fogsiNaploViewFlag = 6;

	@PostConstruct
	public void init() {
		this.horgaszList = this.horgaszFacade.getAllHorgasz();
	}

	public List<Horgasz> getHorgaszList() {
		return this.horgaszList;
	}

	public void setHorgaszList(List<Horgasz> horgaszList) {
		this.horgaszList = horgaszList;
	}

	public boolean[] getViewFlag() {
		return this.viewFlag;
	}

	public int getHalViewFlag() {
		return this.halViewFlag;
	}

	public void setHalViewFlag(int halViewFlag) {
		this.halViewFlag = halViewFlag;
	}

	public int getHorgaszViewFlag() {
		return this.horgaszViewFlag;
	}

	public void setHorgaszViewFlag(int horgaszViewFlag) {
		this.horgaszViewFlag = horgaszViewFlag;
	}

	public int getHorgasztoViewFlag() {
		return this.horgasztoViewFlag;
	}

	public void setHorgasztoViewFlag(int horgasztoViewFlag) {
		this.horgasztoViewFlag = horgasztoViewFlag;
	}

	public int getEngedelyViewFlag() {
		return this.engedelyViewFlag;
	}

	public void setEngedelyViewFlag(int engedelyViewFlag) {
		this.engedelyViewFlag = engedelyViewFlag;
	}

	public int getTelepitesViewFlag() {
		return this.telepitesViewFlag;
	}

	public void setTelepitesViewFlag(int telepitesViewFlag) {
		this.telepitesViewFlag = telepitesViewFlag;
	}

	public int getFogsiNaploViewFlag() {
		return this.fogsiNaploViewFlag;
	}

	public void setFogsiNaploViewFlag(int fogasiNaploViewFlag) {
		this.fogsiNaploViewFlag = fogasiNaploViewFlag;
	}

	public void viewButtonAction(int index) {
		for (int i = 0; i < this.viewFlag.length; i++) {
			if (i == index) {
				this.viewFlag[i] = true;
			} else {
				this.viewFlag[i] = false;
			}
		}
	}

	public void viewButtonAction() {
		for (int i = 0; i < this.viewFlag.length; i++) {
			if (i == 1) {
				this.viewFlag[i] = true;
			} else {
				this.viewFlag[i] = false;
			}
		}
	}

}
