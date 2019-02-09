package com.example.sb_stored_procedure.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Id;
import javax.persistence.Column;

import java.io.Serializable;

@Entity
@Table(name = "customer_custom")	
@NamedStoredProcedureQuery(name = "findCustomCustomerById", procedureName = "FIND_CUSTOM_CUSTOMER_BY_ID", resultClasses = {
		CustomerCustom.class }, parameters = {
				@StoredProcedureParameter(name = "cust_id", type = Long.class, mode = ParameterMode.IN) }

)
public class CustomerCustom implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cust_id")
	private Long custId;

	@Column(name = "full_name")
	private String customerName;

	@Column(name = "country")
	private String country;

	// Default Constructor
	public CustomerCustom() {
	}

	// Cunstructor 1
	public CustomerCustom(Long custId, String customerName, String country) {
		this.custId = custId;
		this.customerName = customerName;
		this.country = country;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
