package com.ll.module_app_member.global.initData;

import com.ll.module_app_member.domain.member.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class All {
    private final MemberService memberService;
    @Autowired
    @Lazy
    private All self;

    @Bean
    public ApplicationRunner initAll() {
        return args -> {
            self.work1();
        };
    }

    @Transactional
    public void work1() {
        if (memberService.count() == 0) {
            memberService.join("admin", "1234");
            memberService.join("system", "1234");
        }
    }
}
