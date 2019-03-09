package com.mmtechsoft.api.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmtechsoft.api.dao.SmsInBoundDaoIF;
import com.mmtechsoft.api.entity.SMSMessageDTO;
import com.mmtechsoft.api.execptions.DaoException;
import com.mmtechsoft.api.execptions.ServiceException;
import com.mmtechsoft.api.vo.SMSMessage;

@Service
public class SMSServiceImpl implements SMSServiceIF {

	private static Logger LOGGER_LOGS = Logger.getLogger("common");

	@Autowired
	private SmsInBoundDaoIF smsInBoundDaoIF;

	public Integer smsUpdate(SMSMessage smsMessage) throws ServiceException {

		SMSMessageDTO smsMessageDTO = new SMSMessageDTO();

		Integer status = 0;
		try {
			smsMessageDTO = smsInBoundDaoIF.findSMSMessageInfoBySmsIDCmpIdMsisdnID(smsMessage.getSmsId(),
					smsMessage.getMsisdn(), smsMessage.getCommunicationId(), smsMessage.getCampId());
			LOGGER_LOGS.info("SMSServiceImpl :smsUpdate  smsMessageDTO Info ==> " + smsMessageDTO);
			if (smsMessageDTO != null) {
				LOGGER_LOGS.info("SMSServiceImpl :smsUpdate  smsMessageDTO Info ==> " + smsMessageDTO.toString());
				if (smsMessageDTO.getSmsStatusFlag() == 4) {
					status = smsInBoundDaoIF.updateSmsInboundIDDetails(smsMessageDTO, 5);
					LOGGER_LOGS
							.info("SMSServiceImpl :smsUpdate  status of (smsInBoundDaoIF.updateSmsInboundIDDetails) ==> "
									+ status);

				} else if (smsMessageDTO.getSmsStatusFlag() == 1) {
					return status = 5;
				} else if (smsMessageDTO.getSmsStatusFlag() == 2) {
					return status = 5;
				} else if (smsMessageDTO.getSmsStatusFlag() == 3) {
					return status = 5;
				} else if (smsMessageDTO.getSmsStatusFlag() == 5) {
					return status = 6;
				}

			} else {
				return status = 7;
			}

		} catch (DaoException e) {
			StackTraceElement st[]=e.getStackTrace();
			LOGGER_LOGS.error("Error into the SMSServiceImpl:smsUpdate" + e.getMessage());
			e.printStackTrace();
		}

		return status;
	}

}
