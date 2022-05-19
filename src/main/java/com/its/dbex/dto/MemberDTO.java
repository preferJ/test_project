package com.its.dbex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 매개변수 생성자
public class MemberDTO {
    private int id;
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberAge;
    private String memberPhone;
}
