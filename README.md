### Spring + Kotlin API Server Study

Entity
- Device
  - id
  - value (sensor value)
  - command

API
- Device
  - GET /v1/devices
    - return all device list
  - POST /v1/devices
    - create new device
  - GET /v1/devices/{deviceId}
    - get device info
  - PATCH /v1/devices/{deviceID}/value
    - update device value
  - PATCH /v1/devices/{deviceID}/command
    - update command
  
