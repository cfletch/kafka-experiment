### Kafka Setup

1. Create docker-compose configuration `vim docker-compose.yml`
    ```yaml
    ---
    version: '3.5'
    
    networks: 
      rmoff_kafka:
        name: rmoff_kafka
    
    services:
      zookeeper:
        image: confluentinc/cp-zookeeper:5.5.0
        container_name: zookeeper
        networks: 
          - rmoff_kafka
        environment:
          ZOOKEEPER_CLIENT_PORT: 2181
    
      broker:
        image: confluentinc/cp-kafka:5.5.0 
        container_name: broker
        networks: 
          - rmoff_kafka
        depends_on:
          - zookeeper
        ports:
          - "19092:19092"
        environment:
          KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://broker:9092,CONNECTIONS_FROM_HOST://localhost:19092
          KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,CONNECTIONS_FROM_HOST:PLAINTEXT
          KAFKA_BROKER_ID: 1
          KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
          KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
    ```

1. Run `docker-compose up`
>Zookeeper and a single node Kafka cluster should now be running and generating log to your terminal

### Running the Java project
1. Run Main class: `com.kafkatest.ProducerConsumerApplication`
1. You should see ouput like:
    ```
    2020-11-23 17:53:01.031  INFO 12529 --- [           main] o.a.k.clients.producer.internals.Sender  : sending message='1:1' to topic='trades'
    2020-11-23 17:53:01.041  INFO 12529 --- [ntainer#0-0-C-1] com.kafkatest.MyConsumer                 : received message='1'
    ```