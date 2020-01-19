package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class StaffVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int staffId;
	@Column(name="fName")
	private String fName;
	@Column(name="lName")
	private String lName;
	@Column(name="gender")
	private String gender;
	@ManyToOne
	DeptVO dvo;
	@ManyToOne
	LoginVO lvo;
	public DeptVO getDvo() {
		return dvo;
	}
	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}
	public LoginVO getLvo() {
		return lvo;
	}
	public void setLvo(LoginVO lvo) {
		this.lvo = lvo;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
		
}
