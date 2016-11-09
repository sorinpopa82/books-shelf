package paya.hz.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by sorin on 08.11.2016.
 */
public class Injector {
    public static <E> E inject(Class<E> c) {
        try {
            return (E) new InitialContext().lookup("java:module/" + c.getSimpleName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
