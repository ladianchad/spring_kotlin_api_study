package com.studuy.study.device

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class DeviceService(
    private val deviceRepository: DeviceRepository
) {
    fun getAllDevice(): Iterable<Device>{
        return  deviceRepository.findAll();
    }

    @Transactional
    fun createDevice(): Device{
        val device = Device()
        return deviceRepository.save(device)
    }

    fun getDevice(deviceId: Long): Device{
        return deviceRepository.findByIdOrNull(deviceId) ?: throw RuntimeException("no device!!")
    }

    @Transactional
    fun updateDeviceValue(deviceId: Long, value: String): Device{
        val device = deviceRepository.findByIdOrNull(deviceId) ?: throw RuntimeException("no device!!")
        device.value = value
        return  deviceRepository.save(device)
    }

    @Transactional
    fun updateDeviceCommand(deviceId: Long, command: String): Device{
        val device = deviceRepository.findByIdOrNull(deviceId) ?: throw RuntimeException("no device!!")
        device.command = command
        return deviceRepository.save(device)
    }
}