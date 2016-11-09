package paya.hz.test;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by sorin on 08.11.2016.
 */
@ApplicationPath("/api")
public class App extends ResourceConfig {
    public App() {
        packages(true, App.class.getPackage().getName());
    }
}
