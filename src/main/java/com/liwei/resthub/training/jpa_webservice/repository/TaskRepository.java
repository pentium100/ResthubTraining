package com.liwei.resthub.training.jpa_webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwei.resthub.training.jpa_webservice.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Task findByTitle(String title);

}
