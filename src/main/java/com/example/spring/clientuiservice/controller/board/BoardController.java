package com.example.spring.clientuiservice.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {

    // 게시글 목록 페이지
    @GetMapping
    public String list() {
        return "/board/list";
    }

    // 게시글 작성 폼
    @GetMapping("/new")
    public String writeForm() {
        return "/board/write";
    }

    // 게시글 수정 폼
    @GetMapping("/{boardId}/edit")
    public String editForm(@PathVariable Long boardId) {
        // 모델에 boardId 기반 데이터 담는 코드가 있어야겠지만 생략
        return "/board/update";
    }

    // 게시글 상세 보기
    @GetMapping("/{boardId}")
    public String detail(@PathVariable Long boardId) {
        return "/board/detail";
    }
}
