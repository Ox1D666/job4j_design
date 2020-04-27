package ru.job4j.structures.generics.store;

public class UserStore implements Store<User> {
    /**
     * User storage.
     */
    private final Store<User> store = new MemStore<>();

    /**
     * Add user in storage.
     * @param user - new user.
     */
    @Override
    public void add(User user) {
        store.add(user);
    }

    /**
     * Exchange one for another.
     * @param id user to replace.
     * @param model - new user.
     * @return success or not.
     */
    @Override
    public boolean replace(String id, User model) {
        return store.replace(id, model);
    }

    /**
     * Delete user.
     * @param id user which we need to delete.
     * @return success or not.
     */
    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    /**
     * Find user by id.
     * @param id user which we need to return.
     * @return user.
     */
    @Override
    public User findById(String id) {
        return store.findById(id);
    }
}
