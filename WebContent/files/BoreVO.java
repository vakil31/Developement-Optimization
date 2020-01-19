package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bore")
public class BoreVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int boreId;
	@Column(name="gender")
	private String gender;
  public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	@Column(name="gender")
	private String gender;
  public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
  public int getboreId() {
		return boreId;
	}
	public void setboreId(int boreId) {
		this.boreId = boreId;
	}
}