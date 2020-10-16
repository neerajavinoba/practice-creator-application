package com.yoga.practicecreatorapplication.services;

import com.yoga.practicecreatorapplication.models.Posture;

import java.util.List;
import java.util.Optional;

public interface IPosturesMasterService
{
	Optional<Posture> findById(Long id);

	List<Posture> findAllPostures();
}
