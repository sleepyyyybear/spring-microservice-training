package com.brownfield.pss.baggage.component;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brownfield.pss.baggage.entity.Baggage;
import com.brownfield.pss.baggage.repository.BaggageRepository;

@Component
public class BaggageComponent {
	private static final Logger logger = LoggerFactory.getLogger(BaggageComponent.class);

	BaggageRepository baggageRepository;
	
	@Autowired
	BaggageComponent(BaggageRepository checkinRepository){
		this.baggageRepository = checkinRepository;
	}

	public long baggage(Baggage checkIn) {
		checkIn.setCheckInTime(new Date());
		logger.info("Saving baggage ");
		//save
		long id = baggageRepository.save(checkIn).getId();
		logger.info("Successfully saved baggage ");
		//send a message back to booking to update status
		logger.info("Sending booking id "+ id);
		return id;
		
	}
	
	public Baggage getBaggageRecord(long id){
		return baggageRepository.findOne(id);
	}
	
}	
