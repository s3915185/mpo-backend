//package com.example.springbootkafkaredis.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class KafkaProducer {
//    public static final String topic = "mytopic";
//
//    @Autowired
//    private KafkaTemplate<String, String> kakfaTemp;
//
//    public void publishToTopic(String message) {
//        System.out.println("Publishing to topic "+topic);
//        this.kakfaTemp.send(topic, message);
//    }
//}
