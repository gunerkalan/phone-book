package com.guner.phonebook.api;

import com.guner.phonebook.dto.PersonDTO;
import com.guner.phonebook.entity.Person;
import com.guner.phonebook.service.PersonService;
import com.guner.phonebook.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = ApiPaths.ContactController.Controller)
@Api(value = ApiPaths.ContactController.Controller)
public class ContactController {

    private final PersonService personService;

    public ContactController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ApiOperation(value = "Save Person Operation",response = PersonDTO.class)
    public ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(personService.save(personDTO));
    }

    @PostMapping("saveForStruct")
    @ApiOperation(value = "Save Person Operation",response = PersonDTO.class)
    public ResponseEntity<PersonDTO> createPersonForStruct(@Valid @RequestBody PersonDTO personDTO){
        return ResponseEntity.ok(personService.saveStruct(personDTO));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = PersonDTO.class)
    public ResponseEntity<PersonDTO> getById(@Valid @PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(personService.getById(id));
    }

    @GetMapping("getById/{id}")
    @ApiOperation(value = "Get By Id Operation", response = PersonDTO.class)
    public ResponseEntity<PersonDTO> getByIdForStruct(@Valid @PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(personService.getByIdStruct(id));
    }

    @GetMapping("/getAll")
    @ApiOperation(value = "Get All Operation", response = String.class, responseContainer = "List")
    public ResponseEntity<List<PersonDTO>> getAll(){
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("getByName/{name}")
    @ApiOperation(value = "Get List By Name Operation", response = String.class, responseContainer = "List")
    public ResponseEntity<List<PersonDTO>> getByName(@Valid @PathVariable("name") String name){
        return ResponseEntity.ok(personService.getByName(name));
    }

    @GetMapping("getBySurname/{surname}")
    @ApiOperation(value = "Get List By Surname Operation", response = String.class, responseContainer = "List")
    public ResponseEntity<List<PersonDTO>> getBySurname(@Valid @PathVariable("surname") String surname){
        return ResponseEntity.ok(personService.getBySurname(surname));

    }

    @GetMapping("getByPhoneNumber/{phoneNumber}")
    @ApiOperation(value = "Get By Phone Number Operation", response = PersonDTO.class)
    public ResponseEntity<PersonDTO> getByPhoneNumber(@Valid @PathVariable String phoneNumber){
        return ResponseEntity.ok(personService.getByPhoneNumber(phoneNumber));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = PersonDTO.class)
    public Map<Object,Object> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO){
        Map<Object,Object> hm = new LinkedHashMap<>();
        hm.put("Person Updated Successfully",personService.update(id,personDTO));
        return hm;
    }

    @DeleteMapping("/{id}")
    public Map<Object,Object> deletePerson(@PathVariable Long id){
        Map<Object,Object> hm = new LinkedHashMap<>();
        hm.put("Person Delete Successfully",personService.delete(id));
        return hm;
    }

    @PutMapping("/softDelete/{id}")
    @ApiOperation(value = "Soft Delete Operation", response = PersonDTO.class)
    public Map<Object,Object> softDeletePerson(@PathVariable Long id, @Valid @RequestBody PersonDTO personDTO){
        Map<Object,Object> hm = new LinkedHashMap<>();
        hm.put("Person Soft Deleted Successfully",personService.softDelete(id,personDTO));
        return hm;
    }
}
