package com.mmtechsoft.api.vo;

public class SMSMessage {

	private String msisdn;
	private String campId;
	private String communicationId;
	private String smsId;
    
    
    

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

	public String toString() {
		return "msisdn=" + msisdn + "| campId=" + campId + "| communicationId=" + communicationId+ "|smsId=" + smsId;
	}

}
