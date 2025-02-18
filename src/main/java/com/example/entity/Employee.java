package com.example.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String status;
	private String deparment;
	private String mobileno;
	private String emailid;
	private String updatedBy;
	private String createdBy;
	private Date createDate;
	private String updateedBy;
	private Date updatedDate;
	private double salary;

	@ManyToOne
	@JoinColumn(name = "cid") // optional
	private Country country;

	public Employee() {

	}

	public Employee(String name, String status, String deparment, String mobileno, String emailid, String updatedBy,
			String createdBy, Date createDate, String updateedBy, Date updatedDate, double salary, Country country) {
		super();
		this.name = name;
		this.status = status;
		this.deparment = deparment;
		this.mobileno = mobileno;
		this.emailid = emailid;
		this.updatedBy = updatedBy;
		this.createdBy = createdBy;
		this.createDate = createDate;
		this.updateedBy = updateedBy;
		this.updatedDate = updatedDate;
		this.salary = salary;
		this.country = country;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateedBy() {
		return updateedBy;
	}

	public void setUpdateedBy(String updateedBy) {
		this.updateedBy = updateedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", status=" + status + ", deparment=" + deparment
				+ ", mobileno=" + mobileno + ", emailid=" + emailid + ", updatedBy=" + updatedBy + ", createdBy="
				+ createdBy + ", createDate=" + createDate + ", updateedBy=" + updateedBy + ", updatedDate="
				+ updatedDate + ", salary=" + salary + ", country=" + country + "]";
	}

}
