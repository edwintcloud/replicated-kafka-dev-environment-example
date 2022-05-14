import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerSubscribeApp {
    public static void main(String[] args) {
        ArrayList<String> topics = new ArrayList<String>(Arrays.asList("mytopic", "myothertopic"));

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "test");

        KafkaConsumer consumer = new KafkaConsumer(props);
        consumer.subscribe(topics);

        try {
            System.out.println("(Topic, Partition, Offset) Key: Value");
            while(true) {
                // get records and print them
                ConsumerRecords<String, String> records = consumer.poll(20);
                for (ConsumerRecord<String, String> record :
                        records) {
                    System.out.printf("(%s, %s, %s) %s: %s\n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
