package com.train.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Index")
public class IndexController {

    /**
     * 登入頁面入口
     */
    @GetMapping("/Login")
    public String Login() {
        return "Index/Login";
    }
}
