package com.keshav.projectify.service;

import com.keshav.projectify.modal.Issue;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    Optional<Issue> getIssueById(Long issueId)throws Exception;

    List<Issue> getProjectByProjectId(Long projectId)throws Exception;

    Issue createIssue(IssueRequest issue,Long userId)throws UserException, IssueException, ProjectException;

    Optional<Issue> updateIssue(Long issueId,IssueRequest updatedIssue,Long userId)throws IssueException,UserException;

    String deleteIssue(Long issueId, Long userId)throws UserException,IssueException;

    List<Issue> getIssuesByAssigneeId(Long assigneeId)throws IssueException;

    List<Issue> searchIssues(String title,String status,String priority, Long assigneeId)throws IssueException;










}
