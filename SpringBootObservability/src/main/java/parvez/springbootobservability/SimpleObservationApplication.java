package parvez.springbootobservability;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleObservationApplication {

    ObservationRegistry observationRegistry = ObservationRegistry.create();
    Observation observation = Observation.createNotStarted("sample", observationRegistry);

    void doSomeObservation() {
        observation.start();
        try (Observation.Scope scope =  observation.openScope()) {
            log.info("Logging inside try after start() triggered");
        }
        catch (Exception e) {
            observation.error(e);
            log.info("Logging inside catch Block after start() triggered");
        }
        finally {
            observation.stop();
        }
    }
}
