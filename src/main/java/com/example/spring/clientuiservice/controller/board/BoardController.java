package com.example.spring.clientuiservice.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {

    @GetMapping("/list")
    public String list() {
        return "/board/list";
    }

    @GetMapping("/write")
    public String write() {
        return "/board/write";
    }

    @GetMapping("/update")
    public String update() {
        return "/board/update";
    }

    @GetMapping("/detail")
    public String detail() {
        return "/board/detail";
    }
}
