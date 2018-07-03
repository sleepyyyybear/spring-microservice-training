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

	public long addBaggage(Baggage baggage) {
		baggage.setCreateDate(new Date());
		logger.info("Saving baggage ");
		//save
		long id = baggageRepository.save(baggage).getId();
		logger.info("Successfully saved baggage " + id);
		return id;
		
	}
	
	public Baggage getBaggage(long id){
		Baggage baggage = baggageRepository.findOne(id);
		baggageRepository.delete(baggage);
		return baggage;
	}
	
}	
