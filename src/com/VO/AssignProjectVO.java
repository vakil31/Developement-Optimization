package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="AssignProject")
public class AssignProjectVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int assignProjectId;
	@ManyToOne
	StaffVO svo;
	@ManyToOne
	ProjectVO pvo;
	public int getAssignProjectId() {
		return assignProjectId;
	}
	public void setAssignProjectId(int assignProjectId) {
		this.assignProjectId = assignProjectId;
	}
	public StaffVO getSvo() {
		return svo;
	}
	public void setSvo(StaffVO svo) {
		this.svo = svo;
	}
	public ProjectVO getPvo() {
		return pvo;
	}
	public void setPvo(ProjectVO pvo) {
		this.pvo = pvo;
	}
}
