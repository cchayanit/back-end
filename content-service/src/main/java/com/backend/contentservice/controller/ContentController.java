package com.backend.contentservice.controller;

import com.backend.contentservice.model.Content;
import com.backend.contentservice.repository.ContentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ContentController {

  @Autowired
  ContentRepository contentRepository;

  @GetMapping("/contents")
  public ResponseEntity<List<Content>> getAllContents(@RequestParam(required = false) String title) {
    try {
      List<Content> contents = new ArrayList<Content>();

      if (title == null)
        contentRepository.findAll().forEach(contents::add);
      else
        contentRepository.findByTitleContaining(title).forEach(contents::add);

      if (contents.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(contents, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  

  @GetMapping("/contents/{id}")
  public ResponseEntity<Content> getContentById(@PathVariable("id") long id) {
    Optional<Content> contentData = contentRepository.findById(id);

    if (contentData.isPresent()) {
      return new ResponseEntity<>(contentData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/contents")
  public ResponseEntity<Content> createContent(@RequestBody Content content) {
    try {
      Content _content = contentRepository
          .save(new Content(content.getTitle(), content.getProtagonist(), content.getDetail()));     //, false
      return new ResponseEntity<>(_content, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/contents/{id}")
  public ResponseEntity<Content> updateContent(@PathVariable("id") long id, @RequestBody Content content) {
    Optional<Content> contentData = contentRepository.findById(id);

    if (contentData.isPresent()) {
      Content _content = contentData.get();
      _content.setTitle(content.getTitle());
      _content.setProtagonist(content.getProtagonist());
      _content.setDetail(content.getDetail());
      return new ResponseEntity<>(contentRepository.save(_content), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/contents/{id}")
  public ResponseEntity<HttpStatus> deleteContent(@PathVariable("id") long id) {
    try {
      contentRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  
  
}