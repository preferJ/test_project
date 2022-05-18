package com.its.dbex.repository;

import com.its.dbex.dto.MemberDTO;

import com.its.dbex.dto.PeopleDTO;
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
}
