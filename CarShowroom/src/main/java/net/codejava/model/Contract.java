package net.codejava.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract {
	private Long contract_id;
	private Date date_of_sale;
	
    private Client client;
    private Car car;
	
	public Contract () {	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getContract_id() {
		return contract_id;
	}

	public void setContract_id(Long contract_id) {
		this.contract_id = contract_id;
	}

	public Date getDate_of_sale() {
		return date_of_sale;
	}

	public void setDate_of_sale(Date date_of_sale) {
		this.date_of_sale = date_of_sale;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id")
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
