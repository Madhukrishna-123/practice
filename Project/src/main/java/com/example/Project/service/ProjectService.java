package com.example.Project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.entity.Project;
import com.example.Project.repo.ProjectRepo;

@Service
public class ProjectService {

	@Autowired
	ProjectRepo projectRepo;

	public Project save(Project project) {
		return projectRepo.save(project);
	}

	public Optional<Project> findById(Long id) {
		
		return projectRepo.findById(id);
	}
	
	
}
