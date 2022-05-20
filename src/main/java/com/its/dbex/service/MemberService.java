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
        int saveResult = memberRepository.memberSave(memberDTO);
        if (saveResult > 0) {
            return true;
        } else {
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

    public MemberDTO memberDetailToid(Long id) {
        MemberDTO memberDetail = memberRepository.memberDetailToid(id);
        return memberDetail;
    }

    public MemberDTO memberDeleteToid(Long id) {
        MemberDTO memberDelete = memberRepository.memberDeleteToid(id);
        return memberDelete;
    }

    public boolean memberUpdate(MemberDTO memberDTO) {
        int memberUpdatgResult = memberRepository.memberUpdate(memberDTO);
        if (memberUpdatgResult > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean memberIdDuplicateCheck(String memberId) {
        MemberDTO dupCheckResult = memberRepository.memberIdDuplicateCheck(memberId);
        if (dupCheckResult != null) {
            return true; // 존재한다.
        } else {
            return false; //존재하지 않는다.
        }
    }


}
