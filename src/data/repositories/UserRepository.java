package data.repositories;

import data.models.User;

public interface UserRepository {
    User save(User user);
    User findBy(String userName);
    void deleteBy(String UserName);
    void deleteBy(User user);
    long count();
}
