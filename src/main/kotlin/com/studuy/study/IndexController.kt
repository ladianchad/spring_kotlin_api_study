package com.studuy.study

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("/")
    fun home(model: Model): String {
        model["title"] = "Spring Kotlin APi"
        model["comment"] = "Spring Kotlin API를 공부하기 위한 사이트 입니다."
        model["entity"] = "Device"
        return "redirect:https://device-ui.lachani.com"
    }
}