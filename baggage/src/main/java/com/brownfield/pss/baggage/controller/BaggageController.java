 	package com.brownfield.pss.baggage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brownfield.pss.baggage.component.BaggageComponent;
import com.brownfield.pss.baggage.entity.Baggage;

@RestController
@CrossOrigin
@RequestMapping("/baggages")
public class BaggageController {

    private static final Logger LOG = LoggerFactory.getLogger(BaggageController.class);

    BaggageComponent baggageComponent;

    @Autowired
    BaggageController (BaggageComponent checkInComponent) {
        this.baggageComponent = checkInComponent;
    }

    @RequestMapping("/get/{checkinId}")
    Baggage getBaggage (@PathVariable long checkinId) {
        LOG.info("Get Baggage with checkin id: " + checkinId);
        return baggageComponent.getBaggage(checkinId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Baggage addBaggage (@RequestBody Baggage baggage) {
        LOG.info("Baggage : " + baggage);
        return baggageComponent.addBaggage(baggage);
    }

}
