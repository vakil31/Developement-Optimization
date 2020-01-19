package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Field")
public class FieldVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fieldId;
	@Column(name="fieldType")
	private String fieldType;
	@Column(name="fieldTitle")
	private String fieldTitle;
	@Column(name="fieldValue")
	private String fieldValue;
	@ManyToOne FormVO formvo;
	public FormVO getFormvo() {
		return formvo;
	}
	public void setFormvo(FormVO formvo) {
		this.formvo = formvo;
	}
	public int getFieldId() {
		return fieldId;
	}
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldTitle() {
		return fieldTitle;
	}
	public void setFieldTitle(String fieldTitle) {
		this.fieldTitle = fieldTitle;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
}
