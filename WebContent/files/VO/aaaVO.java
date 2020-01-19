package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aaa")
public class aaaVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aaaId;
	@Column(name="zz")
	private String zz;
  public String getzz() {
		return zz;
	}
	public void setzz(String zz) {
		this.zz = zz;
	}
  public int getaaaId() {
		return aaaId;
	}
	public void setaaaId(int aaaId) {
		this.aaaId = aaaId;
	}
}