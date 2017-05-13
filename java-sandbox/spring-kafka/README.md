Spring Kafka
------

* Creates a topic
```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic helloworld.t
```

* List topics
```
bin/kafka-topics.sh --list --zookeeper localhost:2181
```

##### References
------
- [1] https://projects.spring.io/spring-kafka/
- [2] https://www.codenotfound.com/2016/09/spring-kafka-consumer-producer-example.html