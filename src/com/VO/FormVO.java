package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Form")

public class FormVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int formId;
	@Column(name="formName")
	private String formName;
	@Column(name="formDetails")
	private String formDetails;
	@ManyToOne
	ModuleVO mvo;
	@ManyToOne
	LoginVO lvo;
	public LoginVO getLvo() {
		return lvo;
	}

	public void setLvo(LoginVO lvo) {
		this.lvo = lvo;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getFormDetails() {
		return formDetails;
	}
	public void setFormDetails(String formDetails) {
		this.formDetails = formDetails;
	}

	public ModuleVO getMvo() {
		return mvo;
	}

	public void setMvo(ModuleVO mvo) {
		this.mvo = mvo;
	}
	
}
