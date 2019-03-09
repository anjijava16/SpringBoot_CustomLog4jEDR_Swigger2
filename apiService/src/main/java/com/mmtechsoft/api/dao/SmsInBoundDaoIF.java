package com.mmtechsoft.api.dao;

import com.mmtechsoft.api.entity.SMSMessageDTO;
import com.mmtechsoft.api.execptions.DaoException;

public interface SmsInBoundDaoIF {

	public SMSMessageDTO	 findSMSMessageInfoBySmsIDCmpIdMsisdnID(String smsId, String msisdnId, String communicationId,
			String cmpId) throws DaoException;

		
	public Integer updateSmsInboundIDDetails(SMSMessageDTO smsMessage,Integer setSmsFlag) throws DaoException;

}
