package com.kafkatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.kafka.streams.annotations.KafkaStreamsProcessor;

import java.time.temporal.ValueRange;
import java.util.Random;

@SpringBootApplication
public class ProducerConsumerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerConsumerApplication.class, args);
	}

	@Autowired
	private Producer sender;

	@Override
	public void run(String... strings) throws Exception {
		Thread.sleep(5 * 1000);	//wait 5 seconds for consumer to be up?
		new Random().ints(0,10)
				.forEach(r -> {
					sender.send(String.valueOf(r), String.valueOf(r));
					try {
						Thread.sleep(1 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
	}
}