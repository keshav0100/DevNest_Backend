package com.keshav.projectify.repository;

import com.keshav.projectify.modal.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentByIssueId(Long issueId);

}
