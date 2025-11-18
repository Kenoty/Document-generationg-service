package com.documentgenerationservice.repository;

import com.documentgenerationservice.model.Template;
import com.documentgenerationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateRepository extends JpaRepository<Template, Long> {
    List<Template> findByUser(User user);
    List<Template> findByUserId(Long userId);
}