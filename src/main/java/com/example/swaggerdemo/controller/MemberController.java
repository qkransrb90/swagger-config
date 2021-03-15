package com.example.swaggerdemo.controller;

import com.example.swaggerdemo.model.Member;
import com.example.swaggerdemo.repository.MemberRepository;
import com.example.swaggerdemo.service.MemberService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "회원_API")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    @ApiOperation(value = "회원 목록 전체 조회", notes = "모든 회원 목록을 조회합니다.")
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/members/{id}")
    @ApiOperation(value = "회원 정보 조회", notes = "회원 아이디를 이용하여 해당 회원의 정보를 조회합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "회원 아이디", example = "아이디 입력", required = true)
    })
    public Member findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PostMapping("/members")
    @ApiOperation(value = "회원 정보 저장", notes = "회원 정보를 생성 및 저장합니다.")
    public Member save(@RequestBody Member member) {
        return memberService.save(member);
    }

    @DeleteMapping("/members/{id}")
    @ApiOperation(value = "회원 정보 삭제", notes = "회원 정보를 삭제합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "회원 아이디", example = "아이디 입력", required = true)
    })
    public void deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
    }
}
