package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Module")

public class ModuleVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int moduleId;
	@Column(name="moduleName")
	private String moduleName;
	@Column(name="moduleDetails")
	private String moduleDetails;
	@ManyToOne
	ProjectVO pvo;
	@ManyToOne
	LoginVO lvo;
	public LoginVO getLvo() {
		return lvo;
	}
	public void setLvo(LoginVO lvo) {
		this.lvo = lvo;
	}
	public ProjectVO getPvo() {
		return pvo;
	}
	public void setPvo(ProjectVO pvo) {
		this.pvo = pvo;
	}
	
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleDetails() {
		return moduleDetails;
	}
	public void setModuleDetails(String moduleDetails) {
		this.moduleDetails = moduleDetails;
	}
	
}
