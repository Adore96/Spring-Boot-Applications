package com.adore96.SpringJWT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringJWT
 */

@Controller
public class userController {

    @RequestMapping("/")
    public String logout() {
        return "index";
    }
}
