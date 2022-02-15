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
        model["entity"] = "Device"
        return "home"
    }
}