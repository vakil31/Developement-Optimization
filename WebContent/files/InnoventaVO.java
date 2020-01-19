package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Innoventa")
public class InnoventaVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int InnoventaId;
	@Column(name="Zeba")
	private String Zeba;
  public int getInnoventaId() {
		return InnoventaId;
	}
	public void setInnoventaId(int InnoventaId) {
		this.InnoventaId = InnoventaId;
	}public String getZeba {
		return Zeba;
	}
	public void setZeba(int Zeba {
		this.Zeba = Zeba;
	}}