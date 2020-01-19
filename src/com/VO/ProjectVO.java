package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class ProjectVO {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int projectId;
		@Column(name="projectName")
		private String projectName;
		@Column(name="projectDetails")
		private String projectDetails;
		
		public int getProjectId() {
			return projectId;
		}
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public String getProjectDetails() {
			return projectDetails;
		}
		public void setProjectDetails(String projectDetails) {
			this.projectDetails = projectDetails;
		}
		

	
}
