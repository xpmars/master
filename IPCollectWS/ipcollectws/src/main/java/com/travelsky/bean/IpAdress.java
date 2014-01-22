package com.travelsky.bean;

import java.sql.Date;

public class IpAdress {
	private int id;
	private String adress;
	private int port;
	private String speed;
	private String country;
	private String province;
	private String city;
	private String isp;
	private boolean isDomestic;
	private boolean isAlive;
	private Date collectDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getIsp() {
		return isp;
	}
	public void setIsp(String isp) {
		this.isp = isp;
	}
	public boolean isDomestic() {
		return isDomestic;
	}
	public void setDomestic(boolean isDomestic) {
		this.isDomestic = isDomestic;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public Date getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((collectDate == null) ? 0 : collectDate.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + (isAlive ? 1231 : 1237);
		result = prime * result + (isDomestic ? 1231 : 1237);
		result = prime * result + ((isp == null) ? 0 : isp.hashCode());
		result = prime * result + port;
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((speed == null) ? 0 : speed.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IpAdress other = (IpAdress) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (collectDate == null) {
			if (other.collectDate != null)
				return false;
		} else if (!collectDate.equals(other.collectDate))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (isAlive != other.isAlive)
			return false;
		if (isDomestic != other.isDomestic)
			return false;
		if (isp == null) {
			if (other.isp != null)
				return false;
		} else if (!isp.equals(other.isp))
			return false;
		if (port != other.port)
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (speed == null) {
			if (other.speed != null)
				return false;
		} else if (!speed.equals(other.speed))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IpAdress [id=" + id + ", adress=" + adress + ", port=" + port
				+ ", speed=" + speed + ", country=" + country + ", province="
				+ province + ", city=" + city + ", isp=" + isp
				+ ", isDomestic=" + isDomestic + ", isAlive=" + isAlive
				+ ", collectDate=" + collectDate + "]";
	}
	

}
