package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class StaffVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int StaffId;
	@Column(name="Zeba")
	private String Zeba;
public int getStaffId() {
		return StaffId;
	}
	public void setStaffId(int StaffId) {
		this.StaffId = StaffId;
	}}