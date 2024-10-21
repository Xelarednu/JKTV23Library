package org.example.repository;

import java.util.List;

public interface Repository<T> {
    void save(List<T> entities);
    List<T> load();
    //List<T> getEntities();
}