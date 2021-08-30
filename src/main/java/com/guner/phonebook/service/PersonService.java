package com.guner.phonebook.service;

import com.guner.phonebook.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO save(PersonDTO personDTO);

    PersonDTO saveStruct(PersonDTO personDTO);

    PersonDTO getById(Long id);

    PersonDTO getByIdStruct(Long id);

    List<PersonDTO> getByName(String name);

    List<PersonDTO> getBySurname(String surname);

    PersonDTO getByPhoneNumber(String phoneNumber);

    List<PersonDTO> getAll();

    PersonDTO update(Long id, PersonDTO personDTO);

    Boolean delete(Long id);

    Boolean softDelete(Long id, PersonDTO personDTO);

}
