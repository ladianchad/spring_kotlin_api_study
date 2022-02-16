package com.studuy.study.device

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class DeviceAPIContorller(
    private val deviceService: DeviceService
) {
    @Operation(summary = "Device list를 주는 API")
    @GetMapping("/v1/devices")
    fun getDevices(): Iterable<Device> {
        return deviceService.getAllDevice()
    }

    @Operation(summary = "Device를 생성하는 API")
    @PostMapping("/v1/devices")
    fun createDevice(): Device {
        return deviceService.createDevice()
    }

    @Operation(summary = "Device data를 주는 API")
    @GetMapping("/v1/devices/{deviceId}")
    fun getDevice(@PathVariable("deviceId") deviceId: Long): Device {
        return deviceService.getDevice(deviceId)
    }

    @Operation(summary = "Device의 value를 수정하는 API")
    @PatchMapping("/v1/devices/{deviceId}/value")
    fun updateDeviceValue(
        @PathVariable("deviceId") deviceId: Long,
        @RequestBody @Validated value: String
    ): Device {
        return deviceService.updateDeviceValue(deviceId, value)
    }

    @Operation(summary = "Device의 command를 수정하는 API")
    @PatchMapping("/v1/devices/{deviceId}/command")
    fun updateDeviceCommand(
        @PathVariable("deviceId") deviceId: Long,
        @RequestBody @Validated command: String
    ): Device {
        return deviceService.updateDeviceCommand(deviceId, command)
    }
}