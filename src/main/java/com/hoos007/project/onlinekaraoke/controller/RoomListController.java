package com.hoos007.project.onlinekaraoke.controller;

import com.hoos007.project.onlinekaraoke.util.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;
import java.util.Map;

@Controller
public class RoomListController {
    private final DBService dbService;

    @Autowired
    public RoomListController(DBService dbService) {
        this.dbService = dbService;
    }

    @GetMapping("/list")
    public String roomList(Model model){
        List<Map<String, AttributeValue>>  result = dbService.scanTable("room");

        model.addAttribute("list", result);
        return "/WEB-INF/views/roomlist.jsp";
    }
}
