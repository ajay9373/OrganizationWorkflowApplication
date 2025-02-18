package com.example.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dao.MainDao;
import com.example.entity.Country;
import com.example.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;

	public String addCountry(@RequestBody Country c) {
		// TODO Auto-generated method stub
		String msg = dao.addCountry(c);

		if (Objects.isNull(msg)) {
			msg = "Country is Not Addedd";
		}

		return msg;

	}
	
	public String updateCountry(Country c, int id) {
		String msg=	dao.updateCountry(c,id);
				if(Objects.isNull(msg)) {
					msg="Country Sucssfully Upadate";
				}
			return msg;
		}

	

	public String delateCountry(int id) {
		// TODO Auto-generated method stub
	String msg=	dao.delateCountry(id);
	
	if(Objects.isNull(msg)) {
		msg="Country is not Delated";
	
	}
	return msg;
		
	}

	public List<Country> getAllCountry() {
		
		List<Country> list=dao.getAllCountry();

		return list;
}

	public Country getParticulerCountryById(int id) {
		Country con=dao.getParticulerCountryById(id);
		return con;
	}

	public String addEmployee(Employee emp) {
		String msg=dao.addEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Employee Added Successfully";
		}
		return msg;
	}



	public String updatedEmployee(Employee emp, int id) {
	String msg=	dao.updatedEmployee(emp,id);
			if(Objects.isNull(msg)) {
				msg="Employee Sucssfully Upadate";
			}
		return msg;
	}

	public String delateEmployee(int id) {
		String msg=dao.delateEmployee(id);
		if(Objects.isNull(msg)) {
			msg="Employee DelateSucsslly";
		}
		
		return msg;
	}
	
	
}