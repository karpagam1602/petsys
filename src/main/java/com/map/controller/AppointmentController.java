package com.map.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.map.bean.Appointment;
import com.map.repository.AppointmentRepository;

@RestController
@CrossOrigin("*")
public class AppointmentController {
	
	@Autowired
	private AppointmentRepository apprepo;

	// to insert the data
	@PostMapping("/doAppInsert")
	public String newApp(@RequestBody Appointment newApp) {
		String msg="Inserted";
		 apprepo.save(newApp);
		 return msg;

	}

	// to get all the data from the database
	@GetMapping("/getAllAppList")
	public List<Appointment> getAllApps() {
		return apprepo.findAll();
	}

	// get by id
		@GetMapping("/GetAppId/{appId}")
		public Optional<Appointment> doAppFind(@PathVariable("appId") int appId) {
			return apprepo.findById(appId);
		}


	// to get all the Id
	@GetMapping("/getAppIdList")
	public List<Integer> getAppbylist() {
		return apprepo.getAllAppointmentId();
	}


	

}
