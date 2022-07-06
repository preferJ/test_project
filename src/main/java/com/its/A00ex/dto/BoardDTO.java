package com.its.A00ex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 매개변수 생성자
public class BoardDTO {
   int id  ;
   String boardTitle ;
    String boardWriter ;
    String boardPassword;
    String boardContents ;
    int boardHits ;
    String boardCreatedDate ;
}


