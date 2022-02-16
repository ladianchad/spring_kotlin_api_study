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
    fun getDeviceList(model: Model): String {
        val devices = deviceService.getAllDevice()
        val devicesDto =  devices.map { device: Device ->
            mapOf(
                "id" to device.id!!,
                "value" to (device.value ?: "null"),
                "command" to (device.command ?: "null")
            )
        }
        model["title"] = "Spring Kotlin APi"
        model["devices"] = devicesDto
        return "device/device"
    }
}