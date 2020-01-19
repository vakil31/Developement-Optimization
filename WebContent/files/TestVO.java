package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class TestVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int testId;
	@Column(name="firstname")
	private String firstname;
  public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
  public int gettestId() {
		return testId;
	}
	public void settestId(int testId) {
		this.testId = testId;
	}
}