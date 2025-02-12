package com.example.Project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Project {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long projectId;
	    private String projectName;
	    private String projectStatus;
}
