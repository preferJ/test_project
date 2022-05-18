package com.its.dbex.service;


import com.its.dbex.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // < @Service 어노테이션을 달아주면 싱글톤패턴 개~꿀~ 쓸려면 쓸려는 클래스에 가서 @Autowired 를 사용 이 설명은 홈컨에 가서 보세요~
public class DataService {
    @Autowired
    private DataRepository Datarepository;

    public void dataSave(String param1, String param2) {
        System.out.println(param1);
        System.out.println(param2);
        Datarepository.dataSave(param1, param2);
    }


}
