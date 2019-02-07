package com.leonardohofling.demoapispring.services;

import com.leonardohofling.demoapispring.dao.ToolRepository;
import com.leonardohofling.demoapispring.models.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToolService {

    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> findMany(final String tag) {

        if (null != tag && !tag.isEmpty()) {
            return toolRepository.findByTags(tag);
        }

        return toolRepository.findAll();
    }

    public Tool create(final Tool tool) {
        return toolRepository.insert(tool);
    }

    public void delete(final String id) {

        final Tool tool = toolRepository.findById(id).orElse(null);
        if (null != tool) {
            toolRepository.delete(tool);
        }
    }
}
