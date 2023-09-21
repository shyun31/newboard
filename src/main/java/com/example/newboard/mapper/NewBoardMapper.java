package com.example.newboard.mapper;

import com.example.newboard.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewBoardMapper {
    List<Board> searchBoard(Board board);

    void deleteBoard(Integer no);
}
