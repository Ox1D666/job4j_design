package ru.job4j.structures.generics.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Object storage.
 * @param <T>
 */
public final class MemStore<T extends Base> implements Store<T> {
    /**
     * Storage collection.
     */
    private final List<T> mem = new ArrayList<>();

    /**
     * Add item in storage.
     * @param model - new item.
     */
    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    /**
     * Exchange one for another.
     * @param id item to replace.
     * @param model - new item.
     * @return success or not.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int count = 0;
        for (var element : this.mem) {
            if (element.getId().equals(id)) {
                mem.set(count, model);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    /**
     * Delete item.
     * @param id item which we need to delete.
     * @return success or not.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int count = 0;
        for (var element : this.mem) {
            if (element.getId().equals(id)) {
                this.mem.remove(count);
                result = true;
                break;
            }
            count++;
        }
        return result;
    }

    /**
     * Find item by id.
     * @param id item which we need to return.
     * @return item.
     */
    @Override
    public T findById(String id) {
        T item = null;
        for (var element : mem) {
            if (element.getId().equals(id)) {
                item = element;
                break;
            }
        }
        return item;
    }
}
