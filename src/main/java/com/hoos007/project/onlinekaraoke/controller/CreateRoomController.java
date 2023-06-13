package com.hoos007.project.onlinekaraoke.controller;

import com.hoos007.project.onlinekaraoke.util.DBService;
import com.hoos007.project.onlinekaraoke.util.GuestIdCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CreateRoomController {

    private final DBService dbService;

    @Autowired
    public CreateRoomController(DBService dbService) {
        this.dbService = dbService;
    }

    String userid;
    String roomid;


    @PostMapping("/createRoom")
    public String createRoom(Model model, RedirectAttributes redirectAttributes, @RequestParam("user_id") String userId, @RequestParam("room_name") String roomName){
        boolean addResult;
        userid = userId;
        if(dbService.getItem("user_id", "id", userid).toString().equals("{}")) {
            dbService.addUserIDItem("user_id", userid);
        } else {
            model.addAttribute("massage", "이미 존재하는 이름입니다.");
            return "/WEB-INF/views/notice.jsp";
        }

        roomid = String.format("%1d",(int)(Math.random()*10));
        //웹소켓 연결 은 클라이언트가 하는거니까 이름이랑 방번호 만들어주기.
        redirectAttributes.addFlashAttribute("userid", userid);
        redirectAttributes.addFlashAttribute("roomid", roomid);
        addResult = dbService.addRoomItem("room", roomid, roomName, "1", "["+userid+"]");
        if (addResult == false)
        {
            model.addAttribute("massage", "방 만들기 실패");
            return "/WEB-INF/views/notice.jsp";
        }

        return "redirect:/room/" + roomid;
    }

    @GetMapping("/room")
    public String enterRoom(RedirectAttributes redirectAttributes, @RequestParam("user_id") String userid, @RequestParam("room_id") String roomid){

        redirectAttributes.addFlashAttribute("userid", userid);
        redirectAttributes.addFlashAttribute("roomid", roomid);
        return "redirect:/room/" + roomid;
    }

}
