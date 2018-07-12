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

	public Baggage addBaggage(Baggage baggage) {
		baggage.setCreateDate(new Date());
		baggage.setAvailable(true);
		logger.info("Saving baggage ");
		//save
		Baggage createdBaggage = baggageRepository.save(baggage);
		logger.info("Successfully saved baggage " + baggage.getId());
		return createdBaggage;
		
	}
	
	public Baggage grabBaggage(long checkinId) throws BaggageNotAvailableException{
		Baggage baggage = baggageRepository.findByBookingId(checkinId);
		if(baggage == null || !baggage.isAvailable()) {
			throw new BaggageNotAvailableException("Baggage is not available!");
		}
		baggage.setAvailable(false);
		return baggageRepository.save(baggage);
	}
	
}
