package com.studuy.study.device

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

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
                "command" to (device.command ?: "null"),
                "url" to "/devices/${device.id!!.toString()}"
            )
        }
        model["title"] = "Device list"
        model["devices"] = devicesDto
        return "device/devices"
    }

    @GetMapping("/devices/{deviceId}")
    fun getDevice(
        @PathVariable("deviceId") deviceId: Long,
        model:Model
    ) : String{
        val device = deviceService.getDevice(deviceId)
        model["title"] = "Device ${device.id}"
        model["id"] = device.id!!.toString()
        model["command"] = device.command ?: "null"
        model["value"] = device.value ?: "null"
        return "device/device"
    }
}