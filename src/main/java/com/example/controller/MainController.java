package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Country;
import com.example.entity.Employee;
import com.example.service.MainService;

@RestController
@RequestMapping("Api")
public class MainController {

	@Autowired
	MainService service;

	@PostMapping("AddCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c) {
		String msg = service.addCountry(c);
		return ResponseEntity.ok(msg);

	}

	@PutMapping("updateCountry/{id}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c, @PathVariable int id) {

		String msg = service.updateCountry(c, id);

		return ResponseEntity.ok(msg);

	}

	@DeleteMapping("DelateCountry/{id}")
	public ResponseEntity<String> delateCountry(@PathVariable int id) {
		String msg = service.delateCountry(id);

		return ResponseEntity.ok(msg);
	}

	@GetMapping("GetAllCountry")
	public ResponseEntity<List<Country>> getAllCountry() {

		List<Country> list = service.getAllCountry();
		return ResponseEntity.ok(list);

	}

	@GetMapping("getCountryById/{id}")
	public ResponseEntity<Country> getParticulerCountryById(@PathVariable int id) {

		Country con = service.getParticulerCountryById(id);
		return ResponseEntity.ok(con);
	}

	@PostMapping("AddEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateEmployee/{id}")
     public ResponseEntity<String> updateEmployee(@RequestBody Employee emp,@PathVariable int id){
	 
     String msg=service.updatedEmployee(emp,id);
	
	 return ResponseEntity.ok(msg);
	
}
	@DeleteMapping("DelateRecourd/{id}")
	public ResponseEntity<String> delateEmployee(@PathVariable int id){
	String msg=service.delateEmployee(id);
	return ResponseEntity.ok(msg);
	}
}