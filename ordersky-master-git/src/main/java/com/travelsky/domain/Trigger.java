/**   
* @Title: Trigger.java
* @author chengjun(chengjun@travelsky.com) 
* @date 2014-2-26 下午4:45:29  
* @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
*/
package com.travelsky.domain;

/**
 * @Description: TODO
 * @author chengjun(chengjun@travelsky.com)  @2014-2-26
 */
public class Trigger {

	private int year;
	private int month;
	private int day;
	private int hour;
	private int second;
	private int minute;
	private String henchman;//henchman的email
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * @return the hour
	 */
	public int getHour() {
		return hour;
	}
	/**
	 * @param hour the hour to set
	 */
	public void setHour(int hour) {
		this.hour = hour;
	}
	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}
	/**
	 * @param second the second to set
	 */
	public void setSecond(int second) {
		this.second = second;
	}
	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}
	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}
	/**
	 * @return the henchman
	 */
	public String getHenchman() {
		return henchman;
	}
	/**
	 * @param henchman the henchman to set
	 */
	public void setHenchman(String henchman) {
		this.henchman = henchman;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Trigger [year=" + year + ", month=" + month + ", day=" + day + ", hour=" + hour
				+ ", second=" + second + ", minute=" + minute + ", henchman=" + henchman + "]";
	}

	
}
