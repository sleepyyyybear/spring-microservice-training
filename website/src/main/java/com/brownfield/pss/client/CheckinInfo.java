package com.brownfield.pss.client;

public class CheckinInfo {
	long id;
    
	double weight;
	
    long checkinId;
 
    public CheckinInfo(){
    }

	public CheckinInfo(double weight, long checkinId) {
		this.weight = weight;
		this.checkinId = checkinId;
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

	public long getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(long checkinId) {
		this.checkinId = checkinId;
	}

	@Override
	public String toString() {
		return "Baggage [id=" + id + ", weight=" + weight + ", checkinId=" + checkinId
				+ "]";
	}

}
