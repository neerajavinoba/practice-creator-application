package com.yoga.practicecreatorapplication.repositories;

import com.yoga.practicecreatorapplication.models.Posture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPosturesRepository extends JpaRepository<Posture, Long>
{
	Optional<Posture> findById(Long id);

	List<Posture> findByType(String type);
}
