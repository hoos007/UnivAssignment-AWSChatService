package com.hoos007.project.onlinekaraoke.controller;

import com.hoos007.project.onlinekaraoke.util.GuestIdCreate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.Objects;

@Controller
public class JspController {

    @RequestMapping("/")
    public String index(){
        return "/WEB-INF/views/index.jsp";
    }

    @RequestMapping("/room/{roomid}")
    public String room(@PathVariable String roomid, HttpServletRequest request, Model model){
        String userid;
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if(flashMap == null){
            GuestIdCreate id = new GuestIdCreate();
            userid = id.create();
            model.addAttribute("userid", userid);
        }
        else{
            model.addAttribute("userid", flashMap.get("userid"));
        }
        model.addAttribute("roomid", roomid);
        return "/WEB-INF/views/room.jsp";
    }

}
