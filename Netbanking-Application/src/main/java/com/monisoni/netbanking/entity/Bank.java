package com.monisoni.netbanking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IFSC")
	private String IFSC;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "state")
	private String state;

	@Column(name = "city")
	private String city;

	@Column(name = "area")
	private String area;

	public Bank() {

	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Bank [IFSC=" + IFSC + ", bankName=" + bankName + ", state=" + state + ", city=" + city + ", area="
				+ area + "]";
	}

}
