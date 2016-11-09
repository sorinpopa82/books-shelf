package paya.hz.test;

import com.hazelcast.core.MapLoader;

import java.util.Collection;
import java.util.Map;

/**
 * Created by sorin on 08.11.2016.
 */
public class MapLoaderBooks implements MapLoader<Long, Book> {
    private EjbBooks ejbBooks = Injector.inject(EjbBooks.class);

    @Override
    public Book load(Long key) {
        return ejbBooks.getOne(key);
    }

    @Override
    public Map<Long, Book> loadAll(Collection<Long> keys) {
        return null;
    }

    @Override
    public Iterable<Long> loadAllKeys() {
        return null;
    }
}
