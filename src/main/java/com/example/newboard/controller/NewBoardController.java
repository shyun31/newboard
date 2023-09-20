package com.example.newboard.controller;

import com.example.newboard.entity.Board;
import com.example.newboard.mapper.NewBoardMapper;
import com.example.newboard.service.NewBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")
public class NewBoardController {

    private final NewBoardService newBoardService;

    // 테스트
    @GetMapping("/board")
    public String board() {
        return "test!";
    }

    // 보드 조회
    @GetMapping("/search")
    public List<Board> searchBoard() {
        return newBoardService.searchBoard();
    }

}

