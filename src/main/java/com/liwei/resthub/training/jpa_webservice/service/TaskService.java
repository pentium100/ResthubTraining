package com.liwei.resthub.training.jpa_webservice.service;

import org.resthub.common.service.CrudService;

import com.liwei.resthub.training.jpa_webservice.model.Task;

public interface TaskService extends CrudService<Task, Long> {

    Task findByTitle(String title);
    Task affectTaskToUser(Long taskId, Long userId);
}