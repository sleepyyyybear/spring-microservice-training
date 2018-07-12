package com.brownfield.pss.checkin.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.brownfield.pss.checkin.entity.CheckInRecord;
import com.brownfield.pss.checkin.repository.CheckinRepository;

@Component
public class CheckinComponent {
	private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);

	CheckinRepository checkinRepository;
	Sender sender;
	RestTemplate baggageClient;
	
	@Autowired
	CheckinComponent(CheckinRepository checkinRepository, Sender sender, RestTemplate baggageClient){
		this.checkinRepository = checkinRepository;
		this.sender = sender;
		this.baggageClient = baggageClient;
	}

	public CheckinInfo checkIn(CheckInRecord checkIn) {
		checkIn.setCheckInTime(new Date());
		logger.info("Saving checkin ");
		//save
		long id = checkinRepository.save(checkIn).getId();
		logger.info("Successfully saved checkin ");
		//send a message back to booking to update status
		logger.info("Sending booking id "+ id);
		sender.send(id);
		CheckinInfo checkInInfo;
		try {
			checkInInfo = baggageClient.getForObject("http://baggage-apigateway/baggage-api/baggages/get/"+checkIn.getBookingId(), CheckinInfo.class);
		} catch(Exception e) {
			logger.warn("Error happened: " + e.getMessage());
			logger.warn("Something wrong happened when trying to grab baggages from baggage service. Will checkin without baggages.");
			checkInInfo = new CheckinInfo();
		}
		checkInInfo.setCheckinId(id); 
		return checkInInfo;
		
	}
	
	public CheckInRecord getCheckInRecord(long id){
		return checkinRepository.findOne(id);
	}
	
}	
