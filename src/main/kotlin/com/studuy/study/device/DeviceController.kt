package com.studuy.study.device

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DeviceController(
    private val deviceService: DeviceService
) {
    @GetMapping("/devices")
    fun getDeviceList(model: Model): String{
        val devices = deviceService.getAllDevice()
        model["title"] = "Spring Kotlin APi"
        model["devices"] = listOf("test","test1")
        return "device/device"
    }
}