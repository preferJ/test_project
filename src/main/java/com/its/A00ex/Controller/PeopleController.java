package com.its.A00ex.Controller;


import com.its.A00ex.dto.PeopleDTO;
import com.its.A00ex.service.PeopleService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PeopleController {
    @Autowired
    private SqlSessionTemplate sql;

    @Autowired
    private PeopleService peopleService;


    @GetMapping("/people-save-form")
    public String peopleSaveForm() {
        return "people/people-save-form";
    }

//    @PostMapping("/people-save")
//    public String peopleSaveReq(@RequestParam("name") String name, @RequestParam("age") int age, Model modle) {
//        PeopleDTO newPeopleDTO = new PeopleDTO();
//        newPeopleDTO.setName(name);
//        newPeopleDTO.setAge(age);
//        peopleService.peopleSave(newPeopleDTO);
//        return "people-save";
//    }

    @PostMapping("/people-save")
    public String peopleSaveReq(@ModelAttribute PeopleDTO peopleDTO) {
        boolean saveResult = peopleService.peopleSave(peopleDTO);
        if(saveResult){
            //저장 성공
            return "index";
        }else {
            //저장 실패
            return "save-fail";
        }

    }




    @GetMapping("/save-print")
    public String peopleSavePrint() {

        return null;
    }

    @GetMapping("/people-list")
    public String findAll(Model model){
        List<PeopleDTO> peopleDTOList = peopleService.findAll();
        model.addAttribute("peopleList",peopleDTOList);
        return "people/people-list";
    }

}