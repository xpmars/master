package com.travelsky.domain;

import java.io.Serializable;

public class Restaurant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6795788807057414208L;
	private Integer restId;
	private String restRame;
	private float score;
	public Integer getRestId() {
		return restId;
	}
	public void setRestId(Integer restId) {
		this.restId = restId;
	}
	public String getRestRame() {
		return restRame;
	}
	public void setRestRame(String restRame) {
		this.restRame = restRame;
	}
	
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Restaurant [restId=" + restId + ", restRame=" + restRame
				+ ", score=" + score + "]";
	}

	
}
