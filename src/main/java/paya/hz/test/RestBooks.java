package paya.hz.test;

import com.hazelcast.core.IMap;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sorin on 08.11.2016.
 */
@Path("/books")
public class RestBooks {
    @EJB
    private CacheManager cacheManager;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response find(@QueryParam(value = "ids") String idsAsStr) {
        if (idsAsStr == null || idsAsStr.isEmpty()) return Response.ok("no ids, no books").build();

        String foundBooksAsHtml = "<html><body>" +
                getCache().get(Long.valueOf(idsAsStr)) +
                "</body</html>";
        return Response.ok(foundBooksAsHtml).build();
    }

    private IMap<Long, Book> getCache() {
        return cacheManager.getCacheInstance().getMap("booksByKey");
    }
}
