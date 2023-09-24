package qubits;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

@Slf4j
public class App {
  public static void main(String[] args) {
    // Connect to Broker + Schema Registry
    String TOPIC = "transactions";
    Properties props = new Properties();

    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

    props.put(ProducerConfig.ACKS_CONFIG, "all");
    props.put(ProducerConfig.RETRIES_CONFIG, 0);
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);

    // Produce Valid Message
    KafkaProducer<String, Payment> producer = new KafkaProducer<String, Payment>(props);
    String id = UUID.randomUUID().toString();
    Payment pymt = new Payment(id, 3.99d);
    producer.send(new ProducerRecord<>(TOPIC, id, pymt));
    log.info("produced, key: {}, value: {}", id, pymt);
    producer.flush();
    producer.close();
  }
}
