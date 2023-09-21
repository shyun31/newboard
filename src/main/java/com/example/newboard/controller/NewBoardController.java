package com.example.newboard.controller;

import com.example.newboard.entity.Board;
import com.example.newboard.service.NewBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    // 조회
    @GetMapping("/search")
    public List<Board> searchBoard(Board board) {
        return newBoardService.searchBoard(board);
    }

    //삭제
    @DeleteMapping("/delete/{boardNo}")
    public void board(@PathVariable Integer boardNo) {
        newBoardService.deleteBoard(boardNo);
    }

}

