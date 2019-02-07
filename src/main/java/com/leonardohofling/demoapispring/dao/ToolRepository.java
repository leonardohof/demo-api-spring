package com.leonardohofling.demoapispring.dao;

import com.leonardohofling.demoapispring.models.Tool;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolRepository extends MongoRepository<Tool, String> {

    List<Tool> findByTags(final String tags);

}
