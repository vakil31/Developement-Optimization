package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Nishi")
public class NishiVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int NishiId;
	@Column(name="Zeba")
	private String Zeba;
  public int getNishiId() {
		return NishiId;
	}
	public void setNishiId(int NishiId) {
		this.NishiId = NishiId;
	}
public String getZeba {
		return Zeba;
	}
	public void setZeba(int Zeba {
		this.Zeba = Zeba;
	}}