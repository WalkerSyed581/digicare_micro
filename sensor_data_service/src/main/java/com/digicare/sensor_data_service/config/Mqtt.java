package com.digicare.sensor_data_service.config;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.digicare.sensor_data_service.models.MqttPublishModel;
import com.digicare.sensor_data_service.models.Reading;
import com.digicare.sensor_data_service.repository.ReadingRepository;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;

public class Mqtt implements MqttCallback  {

	/** The broker url. */
	private static final String brokerUrl ="tcp://localhost:1883";

	/** The client id. */
	private static final String clientId = "clientId";

	public MqttClient sub_client;

	@Autowired
	ReadingRepository repository;

	

	public MqttClient getSub_client() {
		return sub_client;
	}

	public void setSub_client(MqttClient sub_client) {
		this.sub_client = sub_client;
	}

	public void subscribe(String topic) {
		//	logger file name and pattern to log
		MemoryPersistence persistence = new MemoryPersistence();

		try
		{
			
			MqttClient sub_client = new MqttClient(brokerUrl, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);

			System.out.println("checking");
			System.out.println("Mqtt Connecting to broker: " + brokerUrl);

			sub_client.connect(connOpts);
			System.out.println("Mqtt Connected");

			sub_client.setCallback(this);
			sub_client.subscribe(topic);

			System.out.println("Subscribed");
			System.out.println("Listening");

		} catch (MqttException me) {
			System.out.println(me);
		}
	}

	 //Called when the client lost the connection to the broker
	public void connectionLost(Throwable arg0) {
		
	}

	//Called when a outgoing publish is complete
	public void deliveryComplete(IMqttDeliveryToken arg0) {

	}

	// Default LocalDateTIme format : YYYY-MM-DDTHH:MM:SS
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		
		List<String> items = Arrays.asList(message.toString().split("\\s*,\\s*"));
		if(items.size() > 1 && items.get(0) == "R"){
			System.out.println("| Valid Message");
			System.out.println("| Topic:" + topic);
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  

			Reading reading = new Reading(Double.parseDouble(items.get(1)),
										Double.parseDouble(items.get(2)),
										Double.parseDouble(items.get(3)),
										formatter.parse(items.get(4)));
			
			
			reading = repository.save(reading);

			System.out.println("--------------------------------");
			System.out.println(reading.toString());
			System.out.println("");

		} else {
			System.out.println("| Invalid Message");
			System.out.println("| Topic:" + topic);
			System.out.println("| Message: " +message.toString());
			System.out.println("-------------------------------------------------");
		}

	}

	public void publish(MqttPublishModel mqtt_publish_settings){
		//Topic name 
        String topic        = mqtt_publish_settings.getTopic();
        //data to be send
        String content      = mqtt_publish_settings.getMessage();
        int qos             = mqtt_publish_settings.getQos();
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

}
