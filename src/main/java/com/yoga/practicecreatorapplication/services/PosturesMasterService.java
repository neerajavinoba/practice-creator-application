package com.yoga.practicecreatorapplication.services;

import com.yoga.practicecreatorapplication.models.Posture;
import com.yoga.practicecreatorapplication.repositories.IPosturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosturesMasterService implements IPosturesMasterService
{
	@Autowired
	private IPosturesRepository posturesRepository;

	@Override
	public Optional<Posture> findById(Long id)
	{
		return posturesRepository.findById(id);
	}

	@Override public List<Posture> findAllPostures()
	{
		return posturesRepository.findAll();
	}

	public Posture createPosture(Posture posture) {
		return posturesRepository.save(posture);
	}

	public List<Posture> findByType(String postureType) { return posturesRepository.findByType(postureType);}

}
