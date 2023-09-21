package com.example.newboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BoardDto {
    private Integer non;
    private Integer subNo;
    private Integer seq;
    private String largeCode;
    private String middleCode;
    private String title;
    private String contents;
    private Integer level2;
    private String filePath;
    private String fileName;
    private Timestamp regDate;
    private String regUser;
    private Timestamp modDate;
    private String modUser;
}
