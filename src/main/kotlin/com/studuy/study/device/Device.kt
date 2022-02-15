package com.studuy.study.device

import javax.persistence.*

@Entity
@Table(name = "devices")
class Device{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_id", nullable = false)
    var id: Long? = null

    @Column
    var value: String? = null

    @Column
    var command: String? = null
}