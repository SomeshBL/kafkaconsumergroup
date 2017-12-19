# Apache Kafka Consumer Group

## Table of Contents

  * [Run Zookeeper](#run-zookeeper)
  * [Run two instances of broker](#run-two-instances-of-broker)
  * [Create Topic with two replicas and three partitions](#create-topic-with-three-partitions-and-two-replicas)
  * [Run Consumers](#run-consumers)
  * [Run Producer](#run-producer)
  * [Run four Consumers](#run-four-consumers]
  * [Add one more partition to topic](#add-one-more-partition-to-topic)
  * [Run four Consumers again](#run-four-consumers-again)
  
### Run `Zookeeper`
```sh
$ cd kafka_2.12-1.0.0

$ .\bin\windows\zookeeper-server-start.bat config\zookeeper.properties

```

### Run two instances of `Broker`

Copy `server.properties` from `config` directory and make two copies of it named as `server.properties` and `server2.properties` 

```sh
$ cd kafka_2.12-1.0.0

$ .\bin\windows\kafka-server-start.bat config\server.properties

$ .\bin\windows\kafka-server-start.bat config\server2.properties

```

### Create `Topic` with three partitions and two replicas
```sh
$ cd kafka_2.12-1.0.0

$ .\bin\windows\kafka-topics.bat --create --topic my-big-topic --zookeeper localhost:2181 --replication-factor 2 --partitions 3

```

### Run `Consumers`
```sh
$ mvn clean install
$ Run KafkaConsumerGroupApp01
$ Run KafkaConsumerGroupApp02
$ Run KafkaConsumerGroupApp03
```

### Run `Producer`
```sh
$ Run KafkaProducerApp
```  

### Run four Consumers
```sh
Run KafkaConsumerGroupApp01, KafkaConsumerGroupApp02, KafkaConsumerGroupApp03 and one more consumer KafkaConsumerGroupApp04 
```
You will notice that one of the consumer will not get any message due to rebalancing of consumers.

### Add one more Partition to Topic 
```sh
$ cd kafka_2.12-1.0.0

$ .\bin\windows\kafka-topics.bat --alter --topic my-big-topic --zookeeper localhost:2181 --partitions 4
```
### Run four Consumers again
```sh
Run KafkaConsumerGroupApp01, KafkaConsumerGroupApp02, KafkaConsumerGroupApp03 and one more consumer KafkaConsumerGroupApp04 
```
You will notice that all of the consumer will get messages now.

  
