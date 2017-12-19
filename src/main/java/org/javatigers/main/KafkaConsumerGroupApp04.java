package org.javatigers.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * Kafka Consumer Group Application 1
 * @author sk
 *
 */
public class KafkaConsumerGroupApp04 {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092, localhost:9093");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("group.id", "test-group");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		List<String> topics = new ArrayList<>();
		topics.add("my-big-topic");
		
		consumer.subscribe(topics);
		try{
			while(true){
				ConsumerRecords<String, String> records = consumer.poll(10);
				for(ConsumerRecord<String, String> record: records) {
					System.out.println(String.format("Topic: %s, Partition: %d, Value: %s",
							record.topic(), record.partition(), record.value().toUpperCase()));
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			consumer.close();
		}
	}
}

