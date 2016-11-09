package hu.gyigorpeter.anglerregistry.weblayer.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named("backingBean")
public class ManagementBean implements Serializable {

	private static final long serialVersionUID = -554423484774035995L;

	private String test = "test string from cdi backing bean";

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
	
}
