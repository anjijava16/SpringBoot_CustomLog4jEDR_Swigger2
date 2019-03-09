package com.mmtechsoft.api.service;

import com.mmtechsoft.api.vo.SMSMessage;

public class ServiceTest extends Thread {
	public void run() {

		try {
			for (int i = 0; i < 100000000; i++) {
				// System.out.println("1000");
				Thread.sleep(100000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		System.out.println("Before Thread ");
		ServiceTest th = new ServiceTest();
		th.start();

		System.out.println("After Thread ");
		

		// try {
		// int x = 100;
		// int y = 0;
		// int z = x / y;
		// } catch (Exception e) {
		// //e.printStackTrace();
		// //System.out.println(e.fillInStackTrace().getMessage());
		// System.out.println(e.fillInStackTrace()+" ");
		// }

	}

	public static void main1(String[] args) {

		SMSMessage sms = new SMSMessage();
		sms.setCampId("campId");
		sms.setCommunicationId("cammId");
		sms.setMsisdn("akdfk");
		sms.setSmsId("smsId");

	}

}
