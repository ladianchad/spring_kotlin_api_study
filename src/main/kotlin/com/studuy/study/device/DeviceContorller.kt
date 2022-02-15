package com.studuy.study.device

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DeviceContorller(
){
    @GetMapping("/v1/devices")
    fun getDevices(): String{
        return "HelloWorld"
    }
}