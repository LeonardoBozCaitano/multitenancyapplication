package br.com.control.handlers.config;

import java.util.List;

public interface HandlerBase<T> {

    /**
     *  Get All
     *
     * @return a list of {@link T}
     */
    List<T> getAll();

    /**
     *  Get
     *
     * @return a {@link T}
     */
    T get(String id);

    /**
     *  save an object
     *
     * @return the object {@link T} saved
     */
    T save(T dto);

    /**
     *  update an object
     *
     * @return the object {@link T} updated
     */
    T update(String id, T dto);

    /**
     *  delete an object
     */
    void delete(String id);

}