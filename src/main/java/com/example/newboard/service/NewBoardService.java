package com.example.newboard.service;

import com.example.newboard.entity.Board;
import com.example.newboard.mapper.NewBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewBoardService {

    private final NewBoardMapper newBoardMapper;

    // 조회
    public List<Board> searchBoard(Board board) {
        return newBoardMapper.searchBoard(board);
    }

    // 삭제
    public void deleteBoard(Integer no) {
        newBoardMapper.deleteBoard(no);
    }


}
