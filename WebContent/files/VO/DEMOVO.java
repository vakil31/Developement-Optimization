package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEMO")
public class DEMOVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int demoId;
	@Column(name="ss")
	private String ss;
  public String getss() {
		return ss;
	}
	public void setss(String ss) {
		this.ss = ss;
	}
  public int getdemoId() {
		return demoId;
	}
	public void setdemoId(int demoId) {
		this.demoId = demoId;
	}
}