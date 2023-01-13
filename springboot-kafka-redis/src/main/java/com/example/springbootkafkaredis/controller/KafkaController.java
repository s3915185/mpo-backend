//package com.example.springbootkafkaredis.controller;
//
//import com.example.springbootkafkaredis.service.KafkaProducer;
//import org.apache.kafka.clients.producer.Producer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@EnableCaching
//@RequestMapping("/kafkaapp")
//public class KafkaController {
//
//    @Autowired
//    KafkaProducer producer;
//
//    @PostMapping(value = "/post")
//    public void sendMessage(@RequestParam("msg") String msg) {
//        producer.publishToTopic(msg);
//    }
//}
