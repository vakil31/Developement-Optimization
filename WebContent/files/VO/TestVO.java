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
	@Column(name="a")
	private String a;
  public String geta() {
		return a;
	}
	public void seta(String a) {
		this.a = a;
	}
  public int gettestId() {
		return testId;
	}
	public void settestId(int testId) {
		this.testId = testId;
	}
}