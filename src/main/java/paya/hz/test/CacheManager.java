package paya.hz.test;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 * Created by sorin on 08.11.2016.
 */
@Singleton
public class CacheManager {
    private HazelcastInstance cacheInstance;

    public HazelcastInstance getCacheInstance() {

        if (cacheInstance == null) {
            cacheInstance = initHzInstance();
        }
        return cacheInstance;
    }

    public HazelcastInstance initHzInstance() {
        Config config = new Config();

        MapStoreConfig storeConfig = new MapStoreConfig();
        storeConfig.setEnabled(true);
        storeConfig.setClassName(MapLoaderBooks.class.getName());

        config.getMapConfig("booksByKey").setMapStoreConfig(storeConfig);

        return Hazelcast.newHazelcastInstance(config);
    }

    @PreDestroy
    public void shutdown() {
        if (cacheInstance == null) return;
        cacheInstance.shutdown();
    }
}
