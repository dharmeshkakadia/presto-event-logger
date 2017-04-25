import com.facebook.presto.spi.eventlistener.EventListener;
import com.facebook.presto.spi.eventlistener.QueryCompletedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by dharmeshkakadia on 4/19/2017.
 */
public class QueryFileLoggerEventListener implements EventListener{
	static final Logger logger = LoggerFactory.getLogger(QueryFileLoggerEventListener.class);

	public QueryFileLoggerEventListener(Map<String, String> config){}

	public void queryCompleted(QueryCompletedEvent queryCompletedEvent) {
		logger.info(queryCompletedEvent.getContext().getServerVersion() + " : " +
			queryCompletedEvent.getContext().getCatalog() + " : " +
			queryCompletedEvent.getContext().getSchema());
		logger.info(queryCompletedEvent.getMetadata().getQueryId() + " : " +
			queryCompletedEvent.getMetadata().getQueryState() + " : " +
			queryCompletedEvent.getMetadata().getQuery());
		logger.info(queryCompletedEvent.getStatistics().getCompletedSplits() + " : " +
			queryCompletedEvent.getStatistics().getTotalRows() + " : " +
			queryCompletedEvent.getStatistics().getTotalBytes() + " : " +
			queryCompletedEvent.getCreateTime() + " : " +
			queryCompletedEvent.getExecutionStartTime()+ " : " +
			queryCompletedEvent.getEndTime() + " : " +
			queryCompletedEvent.getStatistics().getWallTime().toMillis() + " : " +
			queryCompletedEvent.getStatistics().getQueuedTime().toMillis() + " : " +
			queryCompletedEvent.getStatistics().getAnalysisTime() + " : " +
			queryCompletedEvent.getStatistics().getDistributedPlanningTime() + " : " +
			queryCompletedEvent.getStatistics().getCpuTime().toMillis() + " : " +
			queryCompletedEvent.getStatistics().getPeakMemoryBytes());
		logger.info(queryCompletedEvent.getStatistics().getOperatorSummaries());
	}
}
