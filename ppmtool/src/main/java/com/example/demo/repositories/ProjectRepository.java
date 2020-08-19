package com.example.demo.repositories;

import com.example.demo.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {

        //projectIdentifier
        Project findByProjectIdentifier(String id);


}
