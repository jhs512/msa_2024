package com.ll.module_app_member.domain.member.member.controller;

import com.ll.module_app_member.domain.member.member.dto.MemberDto;
import com.ll.module_app_member.domain.member.member.service.MemberService;
import com.ll.module_common_base.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiV1MemberController {
    private final MemberService memberService;


    public record MemberGetItemsResBody(
            @NonNull List<MemberDto> items
    ) {
    }

    @GetMapping
    public RsData<MemberGetItemsResBody> getItems() {
        return RsData.of(
                new MemberGetItemsResBody(
                        memberService.findAll()
                                .stream()
                                .map(MemberDto::new)
                                .toList()
                ));
    }


    public record MemberGetItemResBody(
            @NonNull MemberDto item
    ) {
    }

    @GetMapping("/{id}")
    public RsData<MemberGetItemResBody> getItems(
            @PathVariable long id
    ) {
        return RsData.of(
                new MemberGetItemResBody(
                        memberService.findById(id)
                                .map(MemberDto::new)
                                .get()
                ));
    }
}
