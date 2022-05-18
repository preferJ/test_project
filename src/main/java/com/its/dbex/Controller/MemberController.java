package com.its.dbex.Controller;

import com.its.dbex.dto.MemberDTO;

import com.its.dbex.dto.PeopleDTO;
import com.its.dbex.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member-save-form")
    public String memberSaveForm() {
        return "member-save-form";
    }

    @GetMapping("/member-index")
    public String memberIndex() {
        return "member-index";
    }

    @PostMapping("/member-save")
    public String memberSaveReq(@ModelAttribute MemberDTO memberDTO) {
        boolean saveResult = memberService.memberSave(memberDTO);
        if (saveResult) {
            //저장 성공
            return "member-login";
        } else {
            //저장 실패
            return "member-index";
        }

    }

    @GetMapping("/member-login")
    public String memberLogin() {
        return "member-login";
    }




    @GetMapping("/member-list")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "member-list";
    }


    @PostMapping("/member-login-req")
    public String memberLoginReq(@ModelAttribute MemberDTO memberDTO) {
        MemberDTO loginMember = memberService.memberLogin(memberDTO);
        if (loginMember.getMemberId() != null) {
            //로그인 성공
            return "member-main";
        } else {
            return "member-index";
        }
    }
}
