package smoketest;

import com.dottydingo.hyperion.client.event.ClientEvent;
import com.dottydingo.hyperion.client.event.ClientEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class MyEventListener implements ClientEventListener
{
    private Logger logger = LoggerFactory.getLogger(MyEventListener.class);
    @Override
    public void handleEvent(ClientEvent clientEvent)
    {
        logger.info("{} - {} - {} - {} {}",
                clientEvent.getHost(),
                clientEvent.getEntity(),
                clientEvent.getRequestMethod(),
                clientEvent.getDuration(),
                clientEvent.isError());
    }
}
