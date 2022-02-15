package com.studuy.study.device

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DeviceContorller(
    private val deviceService: DeviceService
){
    @GetMapping("/v1/devices")
    fun getDevices(): Iterable<Device>{
        return deviceService.getAllDevice()
    }

    @PostMapping("/v1/devices")
    fun createDevice(): Device{
        return  deviceService.createDevice()
    }

    @GetMapping("/v1/devices/{deviceId}")
    fun getDevice(@PathVariable("deviceId") deviceId: Long): Device{
        return deviceService.getDevice(deviceId)
    }
}