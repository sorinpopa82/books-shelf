package paya.hz.test;

import javax.ejb.Stateless;

/**
 * Created by sorin on 08.11.2016.
 */
@Stateless
public class EjbBooks {

    public Book getOne(Long key) {
        return new Book(key);
    }


}
