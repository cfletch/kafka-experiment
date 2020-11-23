package com.kafkatest;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.processor.Processor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.function.Function;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;
import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

//@Service
//@EnableBinding(Processor.class)
//public class StreamingConsumer {
//
//    @Bean
//    public Function<KStream<String, String>, KStream<Windowed<String>, Long>> process() {
//        return input -> input
//                .groupByKey()
//                .windowedBy(TimeWindows.of(10 * 1000))
//                .aggregate(() -> Long.MIN_VALUE,
//                        (Aggregator<String, String, Long>) (key, value, aggregate) -> aggregate + Integer.parseInt(value),
//                        Materialized.as("wordcounts"))
//                .toStream();
//    }
//}