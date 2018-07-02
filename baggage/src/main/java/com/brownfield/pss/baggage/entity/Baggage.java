package com.brownfield.pss.baggage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Baggage {
    @Id
    @GeneratedValue
	long id;
    
	String weight;
	
	@Temporal(TemporalType.TIMESTAMP)
    Date createDate;
    long checkinId;
 
    public Baggage(){
    	
    }
 	
	public Baggage(String weight, Date createDate, long checkinId) {
		super();
		this.weight = weight;
		this.createDate = createDate;
		this.checkinId = checkinId;
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
