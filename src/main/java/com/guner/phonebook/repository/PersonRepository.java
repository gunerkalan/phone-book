package com.guner.phonebook.repository;

import com.guner.phonebook.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getByPhoneNumberOrderById(String phoneNumber);

    Person getByPhoneNumberAndIdNot(String phoneNumber,Long id);

    List<Person> findByNameAndStatusTrueOrderByName(String name);

    @Query("select p from Person p where p.surname like ?1 and p.status = true")
    List<Person> findBySurnameLikeAndStatusTrue(String surname);

    @Query("select p from Person p where p.phoneNumber = ?1 and p.status = true order by p.name")
    Person findByPhoneNumberIsAndStatusTrueOrderByNameAsc(String phoneNumber);

    @Query("select p from Person p where p.status = true")
    List<Person> findByStatusTrue();





}
