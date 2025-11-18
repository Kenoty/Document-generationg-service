package com.documentgenerationservice.repository;

import com.documentgenerationservice.model.Document;
import com.documentgenerationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByUser(User user);
    List<Document> findByUserId(Long userId);
}