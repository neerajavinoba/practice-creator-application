package com.yoga.practicecreatorapplication.controllers;

import com.yoga.practicecreatorapplication.models.Posture;
import com.yoga.practicecreatorapplication.models.Practice;
import com.yoga.practicecreatorapplication.services.PosturesMasterService;
import com.yoga.practicecreatorapplication.services.PracticeCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PostureMasterController
{
	@Autowired
	private PosturesMasterService posturesMasterService;

	@Autowired
	private PracticeCreatorService practiceCreatorService;

	@GetMapping(value = "/showAllPostures", produces = "application/json")
	public List<Posture> getAllPostures() {
		List<Posture> allPostures = posturesMasterService.findAllPostures();
		return allPostures;
	}

	@PostMapping(value = "/addAPosture")
	public Posture addAPosture(@RequestBody Posture posture) {
		return posturesMasterService.createPosture(posture);
	}

	@PostMapping(value = "/createPractice")
	public List<Posture> createPractice(@RequestBody Practice practice) {
		return practiceCreatorService.createPractice(practice);
	}

}
