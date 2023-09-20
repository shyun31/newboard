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

    public List<Board> searchBoard() {
        return newBoardMapper.searchBoard();
    }
}
