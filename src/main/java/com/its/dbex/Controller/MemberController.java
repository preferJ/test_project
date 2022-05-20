package com.its.dbex.Controller;

import com.its.dbex.dto.MemberDTO;

import com.its.dbex.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    public String memberLoginReq(@ModelAttribute MemberDTO memberDTO, Model model, HttpSession session) {
        MemberDTO loginMember = memberService.memberLogin(memberDTO);
        if (loginMember.getMemberId() != null) {
            //로그인 성공
            model.addAttribute("memberList", loginMember);

            // 세션(session)
            session.setAttribute("LoginMemberId", loginMember.getMemberId());
            session.setAttribute("LoginId", loginMember.getId());
            return "member-main";
        } else {
            return "member-index";
        }
    }

    @GetMapping("/member-detail")
    public String memberDetailToid(@RequestParam Long id, Model model) {
        MemberDTO detailMember = memberService.memberDetailToid(id);
        model.addAttribute("detailMember", detailMember);
        return "member-detail";
    }

    @GetMapping("/member-delete")
    public String memberDeleteToid(@RequestParam Long id, Model model) {
        MemberDTO detailMember = memberService.memberDetailToid(id);
        model.addAttribute("detailMember", detailMember);
        memberService.memberDeleteToid(id);
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "member-delete";
        // ※ redirect : 컨트롤러의 메서드에서 다른 메서드의 주소를 호출
        // ※ 문법: redirect:findAll

    }


    @GetMapping("/member-update-form")
    public String memberUpdateForm(HttpSession session, Model model){
        Long updateId = (Long) session.getAttribute("LoginId");
        MemberDTO updateMember = memberService.memberDetailToid(updateId);
        model.addAttribute("updateMember", updateMember);

        return "member-update-form";
    }

    @PostMapping("/member-update")
    public String memberUpdate(@ModelAttribute MemberDTO memberDTO){
        boolean memberUpdateResult = memberService.memberUpdate(memberDTO);
        if (memberUpdateResult){
            return "redirect:/member-detail?id="+memberDTO.getId();
        }else {
            return "fail";
        }
    }


}
