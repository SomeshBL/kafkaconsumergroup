package org.javatigers.main;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Kafka Producer that publish messages to the broker
 * @author sk
 *
 */
public class KafkaProducerApp {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092, localhost:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		try{
			int counter = 0;
			while(counter < 100){
				producer.send(new ProducerRecord<String, String>("my-big-topic", "Producing messages to Topic"));
				counter++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			producer.close();
		}
	}

}
 