package com.its.member.repository;

import com.its.member.DTO.MemberDTO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MemberRepository {

    @Autowired
    private SqlSessionTemplate sql;
    private MemberRepository memberRepository;


    public int memberSave(MemberDTO memberDTO) {
        return sql.insert("member.save", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("member.findAll");
    }

    public MemberDTO memberLogin(MemberDTO memberDTO) {
        return sql.selectOne("member.login",memberDTO);
    }

    public MemberDTO memberDetailToid(Long id) {
        return sql.selectOne("member.detail",id);
    }

    public MemberDTO memberDeleteToid(Long id) {return sql.selectOne("member.delete",id);
    }

    public int memberUpdate(MemberDTO memberDTO) {
        return sql.update("member.update",memberDTO);
    }

    public MemberDTO memberIdDuplicateCheck(String memberId) {
        return sql.selectOne("member.dupCheck",memberId);
    }
}
