package com.studuy.study.device

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.Mockito.any
import org.mockito.Mockito.`when`
import org.assertj.core.api.Assertions.assertThat
import org.mockito.InjectMocks
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class DeviceServiceTest {

    @Mock
    private lateinit var deviceRepository: DeviceRepository

    @InjectMocks
    private lateinit var deviceService: DeviceService

    @Test
    fun `test create device`() {
        //given
        val device = Device()
        device.id = 1

        //when
        `when`(deviceRepository.save(any(Device::class.java))).thenReturn(device)

        //do
        val createdDevice = deviceService.createDevice()

        //then
        assertThat(createdDevice).isNotNull
        assertThat(createdDevice.id).isNotNull
    }

    @Test
    fun `test update value`(){
        //given
        val value = "223142"
        val device = Device()
        device.id = 1

        //when
        `when`(deviceRepository.findById(device.id!!)).thenReturn(Optional.of(device))
        `when`(deviceRepository.save(device)).thenReturn(device)

        //do
        val updatedDevice = deviceService.updateDeviceValue(device.id!!, value)

        //then
        assertThat(updatedDevice.value).isEqualTo(value)
    }

    @Test
    fun `test update command`(){
        //given
        val command = "test command"
        val device = Device()
        device.id = 1

        //when
        `when`(deviceRepository.findById(device.id!!)).thenReturn(Optional.of(device))
        `when`(deviceRepository.save(device)).thenReturn(device)

        //do
        val updatedDevice = deviceService.updateDeviceCommand(device.id!!, command)

        //then
        assertThat(updatedDevice.command).isEqualTo(command)

    }
}