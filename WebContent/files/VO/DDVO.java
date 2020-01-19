package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DD")
public class DDVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ddId;
	@Column(name="dd")
	private String dd;
  public String getdd() {
		return dd;
	}
	public void setdd(String dd) {
		this.dd = dd;
	}
  public int getddId() {
		return ddId;
	}
	public void setddId(int ddId) {
		this.ddId = ddId;
	}
}