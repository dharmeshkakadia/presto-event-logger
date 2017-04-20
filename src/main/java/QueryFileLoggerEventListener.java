import com.facebook.presto.spi.eventlistener.EventListener;
import com.facebook.presto.spi.eventlistener.QueryCompletedEvent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by dharmeshkakadia on 4/19/2017.
 */
public class QueryFileLoggerEventListener implements EventListener{
	FileWriter writer;

	public QueryFileLoggerEventListener(Map<String, String> config){
		try {
			writer = new FileWriter("/var/lib/presto/queries.log");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void queryCompleted(QueryCompletedEvent queryCompletedEvent) {
		try {
			writer.append(" Query : " + queryCompletedEvent.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
