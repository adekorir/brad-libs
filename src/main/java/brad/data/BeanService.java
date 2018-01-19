package brad.data;

import java.util.Collection;

public interface BeanService<T extends Bean> {

    T create(T t) throws BeanServiceException;

    T get(long id) throws BeanServiceException;

    T get(String stringId) throws BeanServiceException;

    Collection<T> getAll() throws BeanServiceException;

    T update(T t) throws BeanServiceException;

    void delete(T t) throws BeanServiceException;
}
