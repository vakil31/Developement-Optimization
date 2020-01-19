package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Demo")
public class DemoVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int demoId;
  public int getdemoId() {
		return demoId;
	}
	public void setdemoId(int demoId) {
		this.demoId = demoId;
	}
	@Column(name="firstname")
	private String firstname;
  public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name="lastname")
	private String lastname;
  public String getlastname() {
		return lastname;
	}
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
}