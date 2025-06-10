package com.keshav.projectify.controller;


import com.keshav.projectify.modal.Issue;
import com.keshav.projectify.modal.IssueDTO;
import com.keshav.projectify.modal.User;
import com.keshav.projectify.repository.IssueRepository;
import com.keshav.projectify.request.IssueRequest;
import com.keshav.projectify.response.AuthResponse;
import com.keshav.projectify.response.MessageResponse;
import com.keshav.projectify.service.IssueService;
import com.keshav.projectify.service.ProjectService;
import com.keshav.projectify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/issues")

public class IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private UserService userService;

    @GetMapping("/{issueId}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Long issueId)throws Exception {
        return ResponseEntity.ok(issueService.getIssueById(issueId));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<Issue> getIssueByProjectId(@PathVariable Long projectId)throws Exception {
        return ResponseEntity.ok(issueService.getIssueById(projectId));
    }

    @PostMapping
    public ResponseEntity<IssueDTO> createIssue(@RequestBody IssueRequest issue,
                                                @RequestHeader("Authorization") String token)
            throws Exception {

        User tokenUser=userService.findUserProfileByJwt(token);
        User user=userService.findUserById(tokenUser.getId());

            Issue createdIssue=issueService.createIssue(issue,tokenUser);
            IssueDTO issueDTO=new IssueDTO();
            issueDTO.setDescription(createdIssue.getDescription());
            issueDTO.setDueDate(createdIssue.getDueDate());
            issueDTO.setId(createdIssue.getId());
            issueDTO.setPriority(createdIssue.getPriority());
            issueDTO.setProject(createdIssue.getProject());
            issueDTO.setProjectID(createdIssue.getProjectID());
            issueDTO.setStatus(createdIssue.getStatus());
            issueDTO.setTitle(createdIssue.getTitle());
            issueDTO.setTags(createdIssue.getTags());
            issueDTO.setAssignee(createdIssue.getAssignee());

            return ResponseEntity.ok(issueDTO);
    }

    @DeleteMapping("/{issueId}")
    public ResponseEntity<MessageResponse> deleteIssue(@PathVariable Long issueId,
                                                    @RequestHeader("Authorization") String token)
            throws Exception {
        User user=userService.findUserProfileByJwt(token);
        issueService.deleteIssue(issueId,user.getId());

        MessageResponse res=new MessageResponse();
        res.setMessage("Issue deleted successfully");
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{issueId}/assignee/{userId}")
    public ResponseEntity<Issue> addUserToIssue(@PathVariable Long issueId,
                                                @PathVariable Long userId)
        throws Exception {

        Issue issue=issueService.addUserToIssue(issueId,userId);
        return ResponseEntity.ok(issue);
    }

    @PutMapping("/{issueId}/status/{status}")
    public ResponseEntity<Issue> updateIssueStatus(
            @PathVariable String status,
            @PathVariable Long issueId) throws Exception {
        Issue issue=issueService.updateStatus(issueId,status);
        return ResponseEntity.ok(issue);
    }


}
