package com.mmtechsoft.api.entity;

import java.sql.Timestamp;

public class SMSMessageDTO {

	private String msisdn;
	private String campId;
	private String communicationId;
	private String smsId;
	private Integer smsStatusFlag;
	private String createdBy;
	private Timestamp createdDate;
	private String updatedBy;
	private Timestamp updatedTime;
	private String smsStatus;
	private String smsBody;
	private String smsLanguage;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getCampId() {
		return campId;
	}

	public void setCampId(String campId) {
		this.campId = campId;
	}

	public String getCommunicationId() {
		return communicationId;
	}

	public void setCommunicationId(String communicationId) {
		this.communicationId = communicationId;
	}

	public String getSmsId() {
		return smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public Integer getSmsStatusFlag() {
		return smsStatusFlag;
	}

	public void setSmsStatusFlag(Integer smsStatusFlag) {
		this.smsStatusFlag = smsStatusFlag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getSmsStatus() {
		return smsStatus;
	}

	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}

	public String getSmsBody() {
		return smsBody;
	}

	public void setSmsBody(String smsBody) {
		this.smsBody = smsBody;
	}

	public String getSmsLanguage() {
		return smsLanguage;
	}

	public void setSmsLanguage(String smsLanguage) {
		this.smsLanguage = smsLanguage;
	}

}
