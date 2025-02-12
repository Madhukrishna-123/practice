package com.example.Project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.entity.Project;
import com.example.Project.service.ProjectService;

@RestController
@RequestMapping("/projects")
class ProjectController {
    
    @Autowired
    private ProjectService projectService;

    @PostMapping("/save")
    public Project saveProject(@RequestBody Project project) {
    	
    	
        return projectService.save(project);
    }

    @GetMapping("/get/{id}")
    public Optional<Project> getProject(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        return projectService.findById(id).map(project -> {
            project.setProjectName(projectDetails.getProjectName());
            project.setProjectStatus(projectDetails.getProjectStatus());
            return projectService.save(project);
        }).orElseThrow(() -> new RuntimeException("Project not found"));
    }
}
