package com.example.demo.services;

import com.example.demo.domain.Project;
import com.example.demo.exceptions.ProjectIdException;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){

            try{
                project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
                return projectRepository.save(project);

            }catch(Exception e){

                throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
            }

    }

    public Project findProjectByIdentifier(String projectId){

        Iterable<Project> pList = projectRepository.findAll();

        Project res = null;
        for(Project p : pList)
        {
            String pId = p.getProjectIdentifier();
            if(pId.equals(projectId.toUpperCase()))
            {
                res = p;
                break;
            }
        }

        if(res==null)
        {
            throw new ProjectIdException("Project ID '" + projectId + "' does not exist.");
        }
        return res;
        //Project project = projectRepository.findByProjectIdentifier(projectId);

        //return project;
    }

    public  Iterable<Project> findAllProjects()
    {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId)
    {
       Project p = findProjectByIdentifier(projectId);

        if(p==null)
        {
            throw new ProjectIdException("Cannot delete project with Project ID '" + projectId + ". This project doesn't exist.");
        }
        projectRepository.delete(p);
    }

    public

}
