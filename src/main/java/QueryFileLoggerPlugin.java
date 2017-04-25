import com.facebook.presto.spi.Plugin;
import com.facebook.presto.spi.eventlistener.EventListenerFactory;
import com.google.common.collect.ImmutableList;

/**
 * Created by dharmeshkakadia on 4/20/2017.
 */
public class QueryFileLoggerPlugin implements Plugin {

	public Iterable<EventListenerFactory> getEventListenerFactories() {
		EventListenerFactory listenerFactory = new QueryFileLoggerEventListenerFactory();
		return ImmutableList.of(listenerFactory);
	}
}
