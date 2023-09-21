package com.example.newboard.mapper;

import com.example.newboard.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewBoardMapper {

    // 조회
    List<Board> searchBoard(Board board);

    // 삭제
    void deleteBoard(Integer non);

    // 저장
    void insertBoard(Board board);
}
