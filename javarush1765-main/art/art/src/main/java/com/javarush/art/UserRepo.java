package com.javarush.art;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
@SpringBootApplication
@ComponentScan("com")
public interface UserRepo extends CrudRepository<Userr, Integer> {

    List<Userr> findByName(String name);
}