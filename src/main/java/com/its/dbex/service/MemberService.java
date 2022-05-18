package com.its.dbex.service;

import com.its.dbex.dto.MemberDTO;

import com.its.dbex.dto.PeopleDTO;
import com.its.dbex.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;

    public boolean memberSave(MemberDTO memberDTO) {
        int saveResult =  memberRepository.memberSave(memberDTO);
        if (saveResult > 0){
            return true;
        }else {
            return false;
        }

    }

    public List<MemberDTO> findAll() {
        List<MemberDTO> memberDTOList = memberRepository.findAll();
        return memberDTOList;
    }

    public MemberDTO memberLogin(MemberDTO memberDTO) {
       MemberDTO memberLogin = memberRepository.memberLogin(memberDTO);
        return memberLogin;
    }
}
