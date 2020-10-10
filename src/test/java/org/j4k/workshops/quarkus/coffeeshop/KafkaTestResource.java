package org.j4k.workshops.quarkus.coffeeshop;


import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.KafkaContainer;

import java.util.Collections;
import java.util.Map;

public class KafkaTestResource implements QuarkusTestResourceLifecycleManager {

    private final KafkaContainer kafkaContainer = new KafkaContainer();

    @Override
    public Map<String, String> start() {
        kafkaContainer.start();
        return Collections.singletonMap("kafka.bootstrap.servers", kafkaContainer.getBootstrapServers());
    }

    @Override
    public void stop() {
        kafkaContainer.stop();
    }
}
