package com.mmtechsoft.api.service;

import com.mmtechsoft.api.execptions.ServiceException;
import com.mmtechsoft.api.vo.SMSMessage;

public interface SMSServiceIF {

	public Integer smsUpdate(SMSMessage smsMessage)throws ServiceException;
	
	
}
