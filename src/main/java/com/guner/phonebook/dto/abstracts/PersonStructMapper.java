package com.guner.phonebook.dto.abstracts;

import com.guner.phonebook.dto.PersonDTO;
import com.guner.phonebook.dto.PersonSlimDTO;
import com.guner.phonebook.entity.Person;

import java.util.List;

public interface PersonStructMapper {

    PersonSlimDTO personToPersonSlimDto(Person person);

    Person personSlimDtoToPerson(PersonSlimDTO personSlimDTO);

    PersonDTO peronToPersonDto(Person person);

    Person personDtoToPerson(PersonDTO personDTO);

    List<PersonDTO> personListToPersonDtoList(List<Person> persons);

    List<Person> personDtoListToPersonList(List<PersonDTO> personDTOList);

}
