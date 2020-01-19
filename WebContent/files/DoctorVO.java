package com.VO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Doctor")
public class DoctorVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int DoctorId;
	@Column(name="Shah")
	private String Shah;
public int getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(int DoctorId) {
		this.DoctorId = DoctorId;
	}}