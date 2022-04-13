package com.github.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public class ProducerDemo {

    public static void main(String[] args) {

        String bootstapServers = "127.0.0.1:9092";

        Properties properties=new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer=new KafkaProducer<String, String>(properties);

        ProducerRecord<String, String> record= new ProducerRecord<String, String>("first-topic", "1441211");
 try {
     producer.send(record);
     producer.close();
 }catch (Exception e){
     e.printStackTrace();
      }
        System.out.println(record.value().toString());
    }
}