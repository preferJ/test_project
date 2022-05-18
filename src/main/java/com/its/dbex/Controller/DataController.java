package com.its.dbex.Controller;


import com.its.dbex.service.DataService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {
    @Autowired
    private SqlSessionTemplate sql;

    @Autowired
    private DataService dataService;


    @GetMapping("data-save-form")
    public String saveForm() {
        return "data-save-form";
    }


    @PostMapping("/data-save")
    public String saveReq(@RequestParam("val1") String val1, @RequestParam("val2") String val2, Model modle) {

        dataService.dataSave(val1, val2);

        return "data-save";
    }

    @GetMapping("/data-save-print")
    public String savePrint() {

        return null;
    }

}