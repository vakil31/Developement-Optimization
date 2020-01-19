package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LJ")
public class LJVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int LJId;
	@Column(name="Zeba")
	private String Zeba;
  public int getLJId() {
		return LJId;
	}
	public void setLJId(int LJId) {
		this.LJId = LJId;
	}
public String getZeba {
		return Zeba;
	}
	public void setZeba(int Zeba {
		this.Zeba = Zeba;
	}}