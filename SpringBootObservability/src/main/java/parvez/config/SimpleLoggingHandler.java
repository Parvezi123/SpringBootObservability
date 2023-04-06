package parvez.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleLoggingHandler implements ObservationHandler<Observation.Context> {

    private static String toString(Observation.Context context) {
        return null == context ? "(no context)" : context.getName()
                + " (" + context.getClass().getName() + "@" + System.identityHashCode(context) + ")";
    }

    private static String toString(Observation.Event event) {
        return null == event ? "(no event)" : event.getName();
    }

    @Override
    public void onStart(Observation.Context context) {
        //ObservationHandler.super.onStart(context);
        log.info("Starting context " + toString(context));

    }

    @Override
    public void onError(Observation.Context context) {
        //ObservationHandler.super.onError(context);
        log.info("Error for context " + toString(context));
    }

    @Override
    public void onScopeOpened(Observation.Context context) {
        //ObservationHandler.super.onScopeOpened(context);
        log.info("Scope Opened for context " + toString(context));
    }

    @Override
    public void onScopeClosed(Observation.Context context) {
        //ObservationHandler.super.onScopeClosed(context);
        log.info("Scoped Closed for context " + toString(context));
    }

    @Override
    public void onStop(Observation.Context context) {
        //ObservationHandler.super.onStop(context);
        log.info("Stopping context " + toString(context));
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }

    @Override
    public void onEvent(Observation.Event event, Observation.Context context) {
        //ObservationHandler.super.onEvent(event, context);
        log.info("Event for context " + toString(context) + " [" + toString(event) + "]");
    }
}
