package com.airtribe.meditrack.util;

import com.airtribe.meditrack.interfaces.Searchable;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DataStore<T> {
    private final List<T> items = Collections.synchronizedList(new ArrayList<>());
    private final Map<Integer, T> idIndex = new ConcurrentHashMap<>();

    public void add(T item) {
        items.add(item);
        try {
            if (item instanceof com.airtribe.meditrack.entity.Person) {
                com.airtribe.meditrack.entity.Person person = (com.airtribe.meditrack.entity.Person) item;
                idIndex.put(person.getId(), item);
            }
        } catch (Exception e) {
            // Ignore indexing errors
        }
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public T findById(int id) {
        return idIndex.get(id);
    }

    public List<T> search(String criteria) {
        return items.stream()
                .filter(item -> item instanceof Searchable)
                .map(item -> (Searchable) item)
                .filter(searchable -> searchable.matches(criteria))
                .map(item -> (T) item)
                .collect(Collectors.toList());
    }
}
