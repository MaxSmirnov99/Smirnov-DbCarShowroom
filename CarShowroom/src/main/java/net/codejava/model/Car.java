package net.codejava.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	private Long car_id;
	private String brand;
	private String model;
	private String color;
	private int year_of_issue; 
	private int number_passport;
	private float price;
	
	private List<Contract> contracts;
	
	public Car() {	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCar_id() {
		return car_id;
	}

	public void setCar_id(Long carId) {
		this.car_id = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear_of_issue() {
		return year_of_issue;
	}

	public void setYear_of_issue(int year_of_issue) {
		this.year_of_issue = year_of_issue;
	}

	public int getNumber_passport() {
		return number_passport;
	}

	public void setNumber_passport(int number_passport) {
		this.number_passport = number_passport;
	}
	
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@OneToMany(targetEntity=Contract.class, mappedBy="car", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	
}
