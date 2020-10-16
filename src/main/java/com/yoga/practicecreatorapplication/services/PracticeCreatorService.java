package com.yoga.practicecreatorapplication.services;

import com.yoga.practicecreatorapplication.models.Posture;
import com.yoga.practicecreatorapplication.models.Practice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Service
public class PracticeCreatorService
{
	@Autowired
	private PosturesMasterService posturesMasterService;

	 Map<String,Integer> postureLevels = Map.of(
	 	"Easy", 1 ,
		 "Intermediate", 2,
		 "Advanced", 3
	 );

	 public List<Posture> createPractice(Practice practice) {
		 Set<Posture> createdPractice = new HashSet<Posture>();
		List<Posture> allPostures = posturesMasterService.findAllPostures();
		 Posture currentPosture;
		Random randomNum = new Random();
		float totalDuration = 0;

		//Initially set the durations for the included practices
		 if( practice.isIncludeBreathing()) {
			 List<Posture> allBreathing =  posturesMasterService.findByType("Breathing");
			 Posture breathing = allBreathing.get(randomNum.nextInt(allBreathing.size()));
			 breathing.setDuration(5.0F);
			 createdPractice.add(breathing);
			 totalDuration = totalDuration + 5.0F;
		 }
		 if( practice.isIncludeMeditation()) {
			 List<Posture> allMeditations =  posturesMasterService.findByType("Meditation");
			 Posture meditation = allMeditations.get(randomNum.nextInt(allMeditations.size()));
			 meditation.setDuration(meditation.getDuration() * practice.getMeditationDuration());
			 createdPractice.add(meditation);
			 totalDuration = totalDuration + practice.getMeditationDuration();
		 }

		 if ( practice.isIncludeSunSalutes() ) {
			 List<Posture> allSunSalutations =  posturesMasterService.findByType("SunSalutations");
			 allSunSalutations.stream().filter(sunSalute -> sunSalute.getLevel().equals(practice.getLevel()));
			 Posture sunSalutation = allSunSalutations.get(randomNum.nextInt(allSunSalutations.size()));
			 totalDuration = totalDuration + practice.getSunSalutationCount() * sunSalutation.getDuration();
			 sunSalutation.setDuration(sunSalutation.getDuration() * practice.getSunSalutationCount());
			 createdPractice.add(sunSalutation);
		 }

		 if( practice.isIncludeYinPostures()) {
		 	List<Posture> allYinPostures = posturesMasterService.findByType("Yin");
		 	float yinDuration = practice.getDuration()/5;
		 	float currentYinDuration = 0;
		 	while(currentYinDuration < yinDuration)
			{
				Posture yinPosture = allYinPostures.get(randomNum.nextInt(allYinPostures.size()));
				createdPractice.add(yinPosture);
				float duration = yinPosture.isDoubleSided()? yinPosture.getDuration()*2:yinPosture.getDuration();
				currentYinDuration = currentYinDuration + duration;
			}
		 	totalDuration = totalDuration + yinDuration;
		 }

		 //Form the asana practice
		while((totalDuration < practice.getDuration())) {

			currentPosture = allPostures.get(randomNum.nextInt(allPostures.size()));
			if(currentPosture.getType().equals("SunSalutations") || currentPosture.getType().equals("Meditation") ||
				currentPosture.getType().equals("Breathing") || currentPosture.getType().equals("Yin") ||
				(practice.getLevel().equals("Easy") && (currentPosture.getLevel().equals("Intermediate") ||
				currentPosture.getLevel().equals("Advanced"))) || (practice.getLevel().equals("Intermediate") && (currentPosture.getLevel().equals("Advanced")))) {
				continue;
			}

			if(createdPractice.size() == 0) {
				createdPractice.add(currentPosture);
				if(currentPosture.isDoubleSided())
				{
					totalDuration = totalDuration + currentPosture.getDuration() * 2;
				} else {
					totalDuration = totalDuration + currentPosture.getDuration();
				}
			}
			else {
				if( (!currentPosture.isDoubleSided()) && ((totalDuration + currentPosture.getDuration()) <= practice.getDuration())) {
					createdPractice.add(currentPosture);
					totalDuration = totalDuration + currentPosture.getDuration();
				}
				else if( (currentPosture.isDoubleSided()) && ((totalDuration + currentPosture.getDuration() * 2) < practice.getDuration())) {
					createdPractice.add(currentPosture);
					totalDuration = totalDuration + currentPosture.getDuration() * 2;
				}
			}
		}
		ArrayList<Posture> practiceCreatedList = new ArrayList<>();
		 if (createdPractice.size() > 0)
		 {
			 practiceCreatedList.addAll(createdPractice);
		 }
		Collections.sort(practiceCreatedList);
		return practiceCreatedList;
	}
}
