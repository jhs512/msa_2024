package com.ll.module_app_member.domain.member.member.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemberControllerTest {
    @Test
    @DisplayName("index 테스트")
    public void t1() {
        assertThat(10 + 20).isEqualTo(30);
    }
}
