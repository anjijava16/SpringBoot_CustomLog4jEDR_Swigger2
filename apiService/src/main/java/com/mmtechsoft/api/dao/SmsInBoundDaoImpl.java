package com.mmtechsoft.api.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mmtechsoft.api.entity.SMSInboundRowMapper;
import com.mmtechsoft.api.entity.SMSMessageDTO;
import com.mmtechsoft.api.execptions.DaoException;

@Transactional
@Repository
public class SmsInBoundDaoImpl implements SmsInBoundDaoIF {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static Logger LOGGER_LOGS = Logger.getLogger("common");
		
	@Override
	public SMSMessageDTO findSMSMessageInfoBySmsIDCmpIdMsisdnID(String smsId, String msisdnId, String communicationId,
			String cmpId) throws DaoException {
		LOGGER_LOGS.info("SmsInBoundDaoImpl::findSMSMessageInfoBySmsIDCmpIdMsisdnID smsId==>"+smsId+"msisdnId==>"+msisdnId+"communicationId==>"+communicationId+"cmpId==>"+cmpId);
		SMSMessageDTO smsMessageDTO = null;
		try {
			String sql = "SELECT * FROM SMS_MESSAGE WHERE SMS_ID=? AND CMG_ID=? AND COMMUNICATION_ID=? AND DESTINATION_ADDRESS=?";
			RowMapper<SMSMessageDTO> rowMapper = new SMSInboundRowMapper();
			smsMessageDTO = jdbcTemplate.queryForObject(sql, new Object[] { smsId, cmpId, communicationId, msisdnId },
					rowMapper);
			LOGGER_LOGS.info("SmsInBoundDaoImpl::findSMSMessageInfoBySmsIDCmpIdMsisdnID smsMessageDTO Info ==="+smsMessageDTO);
		} catch (Exception e) {
			LOGGER_LOGS.error("Error into the SmsInBoundDaoImpl::findSMSMessageInfoBySmsIDCmpIdMsisdnID"+e.getMessage());
			e.printStackTrace();
			smsMessageDTO = null;
		}
		return smsMessageDTO;
	}

	public Integer updateSmsInboundIDDetails(SMSMessageDTO smsMessage, Integer setSmsFlag) throws DaoException {
		LOGGER_LOGS.info("SmsInBoundDaoImpl::updateSmsInboundIDDetails SmsMessage Info ==>"+smsMessage.toString());
		LOGGER_LOGS.info("SmsInBoundDaoImpl::updateSmsInboundIDDetails setSmsFlag Info "+setSmsFlag);
		Integer returnStatus = 0;
		try {
			System.out.println("SmsMessage ===>"+smsMessage.toString());
			String sql = "UPDATE SMS_MESSAGE SET SMS_STATUS_FLAG=?,SMS_STATUS='SMSINBOUNDSERVICE_REQ_CHANGED' WHERE SMS_ID=? AND CMG_ID=? AND COMMUNICATION_ID=? AND DESTINATION_ADDRESS=?";
			returnStatus = jdbcTemplate.update(sql, setSmsFlag, smsMessage.getSmsId(),		smsMessage.getCampId(), smsMessage.getCommunicationId(), smsMessage.getMsisdn());
		   LOGGER_LOGS.info("returnStatus Final Update query is ==>"+returnStatus);
		} catch (Exception e) {
			LOGGER_LOGS.error("Error into the SmsInBoundDaoImpl::updateSmsInboundIDDetails"+e.getMessage());
			e.printStackTrace();
			returnStatus = 10;
		}
		return returnStatus;
	}

}
