package smoketest;

import com.dottydingo.hyperion.client.AuthorizationFactory;
import com.dottydingo.hyperion.client.MultiMap;

import java.util.concurrent.atomic.AtomicInteger;

/**
 */
public class MyAuthorizationFactory implements AuthorizationFactory
{
    private AtomicInteger count = new AtomicInteger(0);
    @Override
    public boolean retryOnAuthenticationError()
    {
        return true;
    }

    @Override
    public MultiMap getHeaders()
    {
        MultiMap map = new MultiMap();
        map.add("authHeader","boo"+count.getAndIncrement());
        return map;
    }

    @Override
    public MultiMap getParameters()
    {
        MultiMap map = new MultiMap();
        map.add("authParam","p"+count.getAndIncrement());
        return map;
    }
}
