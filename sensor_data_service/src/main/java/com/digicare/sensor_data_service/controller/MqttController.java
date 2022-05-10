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
        // if (bindingResult.hasErrors()) {
        //     throw new MqttException(ExceptionMessages.SOME_PARAMETERS_INVALID);
        // }

        // MqttMessage mqttMessage = new MqttMessage(messagePublishModel.getMessage().getBytes());
        // mqttMessage.setQos(messagePublishModel.getQos());
        // mqttMessage.setRetained(messagePublishModel.getRetained());

        // Mqtt.getInstance().publish(messagePublishModel.getTopic(), mqttMessage);

        //Topic name 
        String topic        = "test";
        //data to be send
        String content      = "Temp:20,Humi:70";
        int qos             = 0;
        /*hostname is localhost as mqtt publisher and broker are
          running on the same computer*/ 
        String broker       = "tcp://localhost:1883";
        String clientId     = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);

            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected to broker");
            System.out.println("Publishing message:"+content);
            
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");

            sampleClient.disconnect();
            sampleClient.close();
            System.exit(0);
        } catch(MqttException me) {

                System.out.println("reason "+me.getReasonCode());
                System.out.println("msg "+me.getMessage());
                System.out.println("loc "+me.getLocalizedMessage());
                System.out.println("cause "+me.getCause());
                System.out.println("excep "+me);
                me.printStackTrace();
        }
    }

    // @GetMapping("subscribe")
    // public List<MqttSubscribeModel> subscribeChannel(@RequestParam(value = "topic") String topic,
    //                                                  @RequestParam(value = "wait_millis") Integer waitMillis)
    //         throws InterruptedException, org.eclipse.paho.client.mqttv3.MqttException {
    //     List<MqttSubscribeModel> messages = new ArrayList<>();
    //     CountDownLatch countDownLatch = new CountDownLatch(10);
    //     my_mqtt.subscribeWithResponse(topic, (s, mqttMessage) -> {
    //         MqttSubscribeModel mqttSubscribeModel = new MqttSubscribeModel();
    //         mqttSubscribeModel.setId(mqttMessage.getId());
    //         mqttSubscribeModel.setMessage(new String(mqttMessage.getPayload()));
    //         mqttSubscribeModel.setQos(mqttMessage.getQos());
    //         messages.add(mqttSubscribeModel);
    //         countDownLatch.countDown();
    //     });

    //     countDownLatch.await(waitMillis, TimeUnit.MILLISECONDS);

    //     return messages;
    // }


}
