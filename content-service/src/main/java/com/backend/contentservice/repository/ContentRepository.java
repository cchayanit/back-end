package com.backend.contentservice.repository;

import com.backend.contentservice.model.Content;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContentRepository extends JpaRepository<Content, Long>{
      List<Content> findByTitleContaining(String title);
}
