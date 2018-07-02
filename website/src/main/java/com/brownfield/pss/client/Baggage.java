package com.brownfield.pss.client;

import java.util.Date;

public class Baggage {
	long id;
    
    Double width;
    Double height;
    Double depth;
    Double weight;
    Date checkInTime;
    long bookingId;
 
    public Baggage(){
    	
    }
 	
	public Baggage(Double width, Double height, Double depth, Double weight, Date checkInTime, long bookingId) {
		super();
		this.width = width;
		this.weight = weight;
		this.height = height;
		this.depth = depth;
		this.bookingId = bookingId;
		this.checkInTime = checkInTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getDepth() {
		return depth;
	}

	public void setDepth(Double depth) {
		this.depth = depth;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "BaggageEntity [id=" + id + ", width=" + width + ", height=" + height + ", depth=" + depth + ", weight="
				+ weight + ", checkInTime=" + checkInTime + ", bookingId=" + bookingId + "]";
	}
	
}
