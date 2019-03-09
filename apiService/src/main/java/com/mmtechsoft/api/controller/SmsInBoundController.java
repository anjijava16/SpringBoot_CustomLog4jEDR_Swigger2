package com.mmtechsoft.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.mmtechsoft.api.execptions.ServiceException;
import com.mmtechsoft.api.service.SMSServiceIF;
import com.mmtechsoft.api.utils.DateUtils;
import com.mmtechsoft.api.utils.TACGenerator;
import com.mmtechsoft.api.vo.SMSMessage;

@Controller
@RequestMapping("/user/smsInBoundService")
public class SmsInBoundController {

	@Autowired
	private SMSServiceIF smsMessageService;

	private static Logger LOGGER_LOGS = Logger.getLogger("common");
	private static Logger LOGGER_EDRS = Logger.getLogger("smsadatinbound");

	@PostMapping("smsInBoundService")
	public ResponseEntity<Integer> smsInBoundService(@RequestBody SMSMessage smsMessage, UriComponentsBuilder builder) {
		String trasRefId = TACGenerator.generateOTP(8);
		LOGGER_EDRS.info(
				"SMSINBOUND_REQ" + "|" + DateUtils.processTimestamp() + "|" + trasRefId + "|" + smsMessage.toString());

		Integer status = 0;
		try {
			Integer validationStatus = validationOnRequestParams(smsMessage.getMsisdn(), smsMessage.getCampId(),
					smsMessage.getCommunicationId(), smsMessage.getSmsId());
			LOGGER_LOGS.info("SmsInBoundController:smsInBoundService validationStatus code is " + validationStatus);
			if (validationStatus == 0) {
				status = smsMessageService.smsUpdate(smsMessage);

				if (status == 1) {
					status = 100;
				}
				LOGGER_LOGS.info("SmsInBoundController:smsInBoundService Response Status "+status);
				LOGGER_EDRS.info("SMSINBOUND_RES" + "|" + DateUtils.processTimestamp() + "|" + trasRefId + "|" + status);
			} else {
				status = validationStatus;
				LOGGER_EDRS
						.info("SMSINBOUND_RES" + "|" + DateUtils.processTimestamp() + "|" + trasRefId + "|" + status);
			}
		} catch (ServiceException e) {
			LOGGER_LOGS.error("Error into the SmsInBoundController:smsInBoundService"+e.getMessage());
			status = 0;
			LOGGER_EDRS.info("SMSINBOUND_RES" + "|" + DateUtils.processTimestamp() + "|" + trasRefId + "|" + status);
			e.printStackTrace();

		}

		return new ResponseEntity<Integer>(status, HttpStatus.OK);
	}

	public static Integer validationOnRequestParams(String msisdn, String campId, String communicationId,
			String smsId) {

		boolean msisdnStatus = StringUtils.isEmpty(msisdn) || StringUtils.isBlank(msisdn);
		if (msisdnStatus) {
			return 1;
		}

		boolean campIdStatus = StringUtils.isEmpty(campId) || StringUtils.isBlank(campId);
		if (campIdStatus) {
			return 2;
		}
		boolean communicationIdStatus = StringUtils.isEmpty(communicationId) || StringUtils.isBlank(communicationId);
		if (communicationIdStatus) {
			return 3;
		}
		boolean smsIdStatus = StringUtils.isEmpty(smsId) || StringUtils.isBlank(smsId);
		if (smsIdStatus) {
			return 4;
		}

		return 0;
	}
}
