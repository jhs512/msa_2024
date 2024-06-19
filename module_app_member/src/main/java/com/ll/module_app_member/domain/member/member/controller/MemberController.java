package com.ll.module_app_member.domain.member.member.controller;

import com.ll.module_common_util.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Value("${custom.site.name}")
    private String siteName;

    @GetMapping("")
    @ResponseBody
    public String index() {
        int a = 10 + 20;

        StrUtil.isEmpty("test");

        return siteName + "에 오신것을 환영합니다.";
    }
}
