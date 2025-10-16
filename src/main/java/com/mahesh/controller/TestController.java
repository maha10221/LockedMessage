package com.mahesh.controller;

import com.mahesh.entity.Message;
import com.mahesh.serviceimplimentation.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private MessageDAO messageDAO;
    @GetMapping("/getAllEntries")
    public List<Message> getAllEntries (){
        return messageDAO.getAllEntry();
    }
}
