package com.guner.phonebook.service.impl;

import com.guner.phonebook.dto.PersonDTO;
import com.guner.phonebook.dto.abstracts.PersonStructMapper;
import com.guner.phonebook.entity.Person;
import com.guner.phonebook.repository.PersonRepository;
import com.guner.phonebook.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;
    private final PersonStructMapper personStructMapper;

    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper, PersonStructMapper personStructMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
        this.personStructMapper = personStructMapper;
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        Person personDb = personRepository.getByPhoneNumberOrderById(personDTO.getPhoneNumber());
        if(personDb != null){
           throw new IllegalArgumentException("Phone Number is defined !");
        }

        personDTO.setStatus(Boolean.TRUE);
        Person person = modelMapper.map(personDTO,Person.class);
        person = personRepository.save(person);
        personDTO.setId(person.getId());

        return personDTO;
    }

    @Override
    public PersonDTO saveStruct(PersonDTO personDTO) {
        Person personDb = personRepository.getByPhoneNumberOrderById(personDTO.getPhoneNumber());
        if(personDb != null){
            throw new IllegalArgumentException("Phone Number is defined !");
        }

        personDTO.setStatus(Boolean.TRUE);
        Person person = personStructMapper.personDtoToPerson(personDTO);
        person = personRepository.save(person);
        personDTO.setId(person.getId());

        return personDTO;
    }

    @Override
    public PersonDTO getById(Long id) {
        Optional<Person> personIs = Optional.of(personRepository.getById(id));

        return modelMapper.map(personIs.get(),PersonDTO.class);
    }

    @Override
    public PersonDTO getByIdStruct(Long id) {
        Optional<Person> personIs = Optional.of(personRepository.getById(id));

        return personStructMapper.peronToPersonDto(personIs.get());
    }

    @Override
    public List<PersonDTO> getByName(String name) {
        List<Person> persons = personRepository.findByNameAndStatusTrueOrderByName(name);

        return Arrays.asList(modelMapper.map(persons,PersonDTO[].class));
    }

    @Override
    public List<PersonDTO> getBySurname(String surname) {
        List<Person> persons = personRepository.findBySurnameLikeAndStatusTrue(surname);

        return Arrays.asList(modelMapper.map(persons,PersonDTO[].class));
    }

    @Override
    public PersonDTO getByPhoneNumber(String phoneNumber) {
        Optional<Person> person = Optional.ofNullable(personRepository.findByPhoneNumberIsAndStatusTrueOrderByNameAsc(phoneNumber));

        return modelMapper.map(person.get(),PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAll() {
       List<Person> persons = personRepository.findByStatusTrue();

       return Arrays.asList(modelMapper.map(persons,PersonDTO[].class));
    }

    @Override
    public PersonDTO update(Long id, PersonDTO personDTO) {

        Person personDb = personRepository.getById(id);
        if(personDb==null){
            throw new IllegalArgumentException("Person Not Found"+ id);
        }

        Person personCheck = personRepository.getByPhoneNumberAndIdNot(personDTO.getPhoneNumber(),id);
        if(personCheck!=null){
            throw new IllegalArgumentException("The person is defined");
        }

        personDb.setName(personDTO.getName());
        personDb.setSurname(personDTO.getSurname());
        personDb.setPhoneNumber(personDTO.getPhoneNumber());
        personDb.setNotes(personDTO.getNotes());

        personRepository.save(personDb);
        return modelMapper.map(personDb,PersonDTO.class);

    }

    @Override
    public Boolean delete(Long id) {
        personRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean softDelete(Long id, PersonDTO personDTO) {
        Person personDb = personRepository.getById(id);
        if(personDb==null){
            throw new IllegalArgumentException("Person Not Found"+ id);
        }

        personDb.setStatus(Boolean.FALSE);

        personRepository.save(personDb);
        return Boolean.TRUE;
    }
}
