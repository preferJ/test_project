package com.its.dbex.repository;


import com.its.dbex.dto.MemberDTO;
import com.its.dbex.dto.PeopleDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleRepository {

    @Autowired
    private SqlSessionTemplate sql;
    private PeopleRepository peopleRepository;


    public void peopleSave(String param1, int param2) {
        PeopleDTO newPeopleDTO = new PeopleDTO();
        newPeopleDTO.setName(param1);
        newPeopleDTO.setAge(param2);

        sql.insert("people.save", newPeopleDTO);
    }

    public int peopleSave(PeopleDTO newPeopleDTO) {

       return sql.insert("people.save", newPeopleDTO);

    }

    public List<PeopleDTO> findAll() {
        return sql.selectList("people.findAll");
    }
}
