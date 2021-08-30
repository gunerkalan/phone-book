package com.guner.phonebook.dto.concrete;

import com.guner.phonebook.dto.PersonDTO;
import com.guner.phonebook.dto.PersonSlimDTO;
import com.guner.phonebook.dto.abstracts.PersonStructMapper;
import com.guner.phonebook.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonStructMapperImpl implements PersonStructMapper {
    @Override
    public PersonSlimDTO personToPersonSlimDto(Person person) {
        if(person == null){
            return null;
        }

        PersonSlimDTO personSlimDTO = new PersonSlimDTO();
        personSlimDTO.setId(person.getId());
        personSlimDTO.setName(person.getName());
        personSlimDTO.setSurname(person.getSurname());

        return personSlimDTO;
    }

    @Override
    public Person personSlimDtoToPerson(PersonSlimDTO personSlimDTO) {
        if(personSlimDTO == null){
            return null;
        }

        Person person = new Person();
        person.setId(personSlimDTO.getId());
        person.setName(personSlimDTO.getName());
        person.setSurname(personSlimDTO.getSurname());

        return person;
    }

    @Override
    public PersonDTO peronToPersonDto(Person person) {
        if(person == null){
            return null;
        }

        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        personDTO.setPhoneNumber(person.getPhoneNumber());
        personDTO.setNotes(person.getNotes());
        personDTO.setStatus(person.getStatus());

        return personDTO;
    }

    @Override
    public Person personDtoToPerson(PersonDTO personDTO) {
        if(personDTO == null){
            return null;
        }

        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        person.setSurname(personDTO.getSurname());
        person.setPhoneNumber(personDTO.getPhoneNumber());
        person.setNotes(personDTO.getNotes());
        person.setStatus(personDTO.getStatus());

        return person;
    }

    @Override
    public List<PersonDTO> personListToPersonDtoList(List<Person> persons) {
       if(persons == null){
           return null;
       }

       List<PersonDTO> list = new ArrayList<PersonDTO>(persons.size());
       for(Person person : persons){
           list.add(peronToPersonDto(person));
       }

       return list;
    }

    @Override
    public List<Person> personDtoListToPersonList(List<PersonDTO> personDTOList) {
        if(personDTOList == null){
            return null;
        }

        List<Person> personList = new ArrayList<Person>(personDTOList.size());
        for(PersonDTO personDTO : personDTOList){
            personList.add(personDtoToPerson(personDTO));
        }
        return personList;
    }
}
