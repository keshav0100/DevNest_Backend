package com.keshav.projectify.service;

import com.keshav.projectify.modal.Project;
import com.keshav.projectify.modal.User;
import com.keshav.projectify.modal.Chat;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface ProjectService
{

    Project createProject(Project project,User user)throws Exception;

    List<Project> getProjectByTeam(User user, String category, String tag)throws Exception;

    Project getProjectById(Long projectId)throws Exception;

    void deleteProject(Long projectId,Long UserId)throws Exception;

    Project updateProject(Project updatedProject,Long id)throws Exception;

    void addUserToProject(Long projectId,Long userId)throws Exception;

    void removeUserFromProject(Long projectId,Long userId)throws Exception;

    Chat getChatByProjectId(Long projectId)throws Exception;

    List<Project> searchProjects(String keyword,User user)throws Exception;

}
