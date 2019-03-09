package com.mmtechsoft.api.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

		
public class SMSInboundRowMapper implements RowMapper<SMSMessageDTO> {

		
	public SMSMessageDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		SMSMessageDTO smsMessage = new SMSMessageDTO();
		smsMessage.setCampId(rs.getString("CMG_ID"));
		smsMessage.setMsisdn(rs.getString("DESTINATION_ADDRESS"));
		smsMessage.setSmsId(rs.getString("SMS_ID"));
		smsMessage.setCommunicationId(rs.getString("COMMUNICATION_ID"));
		smsMessage.setSmsStatusFlag(rs.getInt("SMS_STATUS_FLAG"));
		return smsMessage;
	}

}
