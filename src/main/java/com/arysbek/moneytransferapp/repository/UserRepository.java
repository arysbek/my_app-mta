package com.arysbek.moneytransferapp.repository;

import com.arysbek.moneytransferapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findTop10ByFirstName(String firstName);
    Iterable<User> findTop10ByLastName(String lastName);
    Iterable<User> findByEmail(String Email);

    Iterable<User> findTop10ByFirstNameAndLastName(String firstName, String lastName);

    @Query(nativeQuery = true, value = "select * from users limit 10")
    Iterable<User> findAllTopTen();

    Iterable<User> findByFirstName(String firstName);
}
