import com.facebook.presto.spi.eventlistener.EventListener;
import com.facebook.presto.spi.eventlistener.EventListenerFactory;

import java.util.Map;

/**
 * Created by dharmeshkakadia on 4/19/2017.
 */
public class QueryFileLoggerEventListenerFactory implements
	EventListenerFactory {
	public String getName() {
		return "event-logger";
	}

	public EventListener create(Map<String, String> config) {
		return new QueryFileLoggerEventListener(config);
	}
}
