package com.digicare.sensor_data_service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.digicare.sensor_data_service.config.Mqtt;
import com.digicare.sensor_data_service.models.MqttPublishModel;

import com.digicare.sensor_data_service.exceptions.ExceptionMessages;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import com.digicare.sensor_data_service.models.MqttSubscribeModel;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.web.bind.annotation.*;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.concurrent.CountDownLatch;
// import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/api/mqtt")
public class MqttController {

    @Autowired
    Mqtt my_mqtt;

    

    @PostMapping("publish")
    public void publishMessage(@RequestBody MqttPublishModel messagePublishModel,
                               BindingResult bindingResult) throws org.eclipse.paho.client.mqttv3.MqttException {
        
    }

    @GetMapping("subscribe")
    public void subscribeChannel(@RequestParam(value = "topic") String topic)
            throws InterruptedException, org.eclipse.paho.client.mqttv3.MqttException {
        my_mqtt.subscribe(topic);
    }


}
