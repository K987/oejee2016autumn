package hu.gyigorpeter.anglerregistry.weblayer.bean;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "managedBean")
public class ManagementBean implements Serializable {

	private static final long serialVersionUID = -554423484774035995L;

	private String test = "test string";

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
	
}
