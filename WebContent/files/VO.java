package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="")
public class VO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
  public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
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