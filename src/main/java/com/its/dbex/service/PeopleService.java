package com.its.dbex.service;


import com.its.dbex.dto.PeopleDTO;
import com.its.dbex.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // < @Service 어노테이션을 달아주면 싱글톤패턴 개~꿀~ 쓸려면 쓸려는 클래스에 가서 @Autowired 를 사용 이 설명은 홈컨에 가서 보세요~
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;

    public void peopleSave(String param1, int param2) {
        peopleRepository.peopleSave(param1, param2);
    }


    public boolean peopleSave(PeopleDTO newPeopleDTO) {
        int saveResult =  peopleRepository.peopleSave(newPeopleDTO);
        if (saveResult > 0){
            return true;
        }else {
            return false;
        }

    }
}
