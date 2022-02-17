package com.studuy.study

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("/")
    fun home(model: Model): String {
        return "redirect:https://device-ui.lachani.com"
    }
}