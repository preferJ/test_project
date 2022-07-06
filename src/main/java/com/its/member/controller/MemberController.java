package com.its.member.controller;

import com.its.member.DTO.MemberDTO;

import com.its.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member-index")
    public String memberIndex() {
        return "member/member-index";
    }

    @GetMapping("/member-save-form")
    public String memberSaveForm() {
        return "member/member-save-form";
    }

    @GetMapping("/member-response-test1")
    public @ResponseBody String memberResponseTest1() {
        return "member-main";
    }

    @GetMapping("/member-response-test2")
    public @ResponseBody List<MemberDTO> memberResponseTest2() {
        return memberService.findAll();

    }

    @PostMapping("/member-save")
    public String memberSaveReq(@ModelAttribute MemberDTO memberDTO) {
        boolean saveResult = memberService.memberSave(memberDTO);
        if (saveResult) {
            //저장 성공
            return "member/member-login";
        } else {
            //저장 실패
            return "member/member-index";
        }

    }

    @GetMapping("/member-login")
    public String memberLogin() {
        return "member/member-login";
    }


    @GetMapping("/member-list")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "member/member-list";
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
            return "member/member-main";
        } else {
            return "member/member-index";
        }
    }

    @GetMapping("/member-detail")
    public String memberDetailToid(@RequestParam Long id, Model model) {
        MemberDTO detailMember = memberService.memberDetailToid(id);
        model.addAttribute("detailMember", detailMember);
        return "member/member-detail";
    }

    @GetMapping("/member-delete")
    public String memberDeleteToid(@RequestParam Long id, Model model) {
        MemberDTO detailMember = memberService.memberDetailToid(id);
        model.addAttribute("detailMember", detailMember);
        memberService.memberDeleteToid(id);
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList", memberDTOList);
        return "member/member-delete";
        // ※ redirect : 컨트롤러의 메서드에서 다른 메서드의 주소를 호출
        // ※ 문법: redirect:findAll

    }


    @GetMapping("/member-update-form")
    public String memberUpdateForm(HttpSession session, Model model) {
        Long updateId = (Long) session.getAttribute("LoginId");
        MemberDTO updateMember = memberService.memberDetailToid(updateId);
        model.addAttribute("updateMember", updateMember);

        return "member/member-update-form";
    }

    @PostMapping("/member-update")
    public String memberUpdate(@ModelAttribute MemberDTO memberDTO) {
        boolean memberUpdateResult = memberService.memberUpdate(memberDTO);
        if (memberUpdateResult) {
            return "redirect:/member-detail?id=" + memberDTO.getId();
        } else {
            return "fail";
        }
    }
    // ajax() : 비동기
    // full name : Asynchronous Javascript And XML
    // Jquery활용
    // @ResponseBody :


    @PostMapping("/member-duplicate-check")
    public @ResponseBody String memberIdDuplicateCheck(@RequestParam String memberId) {
        System.out.println("memberId = " + memberId);
        // memberId를 DB에서 중복값이 있는지 없는지 체크하고
        // 없으면 ok 있으면 no 라는 String 값을 리턴받으세요

        boolean dupCheckResult = memberService.memberIdDuplicateCheck(memberId);
        if (dupCheckResult) {
            System.out.println("사용불가 ");
            return "NO";
        } else {
            System.out.println("사용가능 ");
            return "OK";
        }

    }

    @GetMapping("/detail-ajax")
    public @ResponseBody MemberDTO findByIdAjax(@RequestParam("id") Long id) {
        System.out.println("id = " + id);
        MemberDTO memberDTO = memberService.memberDetailToid(id);
        return memberDTO;
    }


    @GetMapping("/member-logout")
    public String memberLogout(HttpSession session){
        session.invalidate(); //세션 무효화 = 로그아웃
        return "index";

    }

}




