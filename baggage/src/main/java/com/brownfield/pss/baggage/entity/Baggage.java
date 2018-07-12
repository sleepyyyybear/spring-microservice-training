package com.brownfield.pss.baggage.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Baggage {
    @Id
    @GeneratedValue
	long id;
    boolean available;
	double weight;
	
	@Temporal(TemporalType.TIMESTAMP)
    Date createDate;
    long bookingId;
 
    public Baggage(){
    	
    }

	public Baggage(double weight, Date createDate, long bookingId) {
		this.weight = weight;
		this.createDate = new Date();
		this.available = true;
		this.bookingId = bookingId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@JsonIgnore
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Baggage [id=" + id + ", weight=" + weight + ", createDate=" + createDate + ", bookingId=" + bookingId
				+ "]";
	}

}
