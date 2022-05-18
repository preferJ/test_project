package com.its.dbex.repository;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

    @Autowired
    private SqlSessionTemplate sql;


    public void dataSave(String param1, String param2) {
        System.out.println("요긴 저장소");
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        sql.insert("Data.save", param1);
    }
}
