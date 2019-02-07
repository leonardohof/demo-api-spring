package com.leonardohofling.demoapispring.controllers;

import com.leonardohofling.demoapispring.models.Tool;
import com.leonardohofling.demoapispring.services.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToolsController {

    @Autowired
    private ToolService toolService;

    @GetMapping(value = "/tools", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tool>> findTools(@RequestParam(name = "tag", defaultValue = "") final String tag) {

        return new ResponseEntity<>(toolService.findMany(tag), HttpStatus.OK);
    }

    @PostMapping(value = "/tools", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tool> createTool(@RequestBody final Tool tool) {

        return new ResponseEntity<>(toolService.create(tool), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/tools/{id}")
    public ResponseEntity<Void> deleteTool(@PathVariable(name = "id") final String id) {

        toolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
