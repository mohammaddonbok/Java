package com.relationship.demo.Services;

import com.relationship.demo.models.Person;
import com.relationship.demo.Reopsitories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService{

    private  final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public List<Person> allPerson(){
        return personRepository.findAll();
    }


    public Person addPerson(Person person){

        return personRepository.save(person);
    }

    public  Person findPersonById( Long id){

        Optional<Person> person= personRepository.findById(id);
        if(person.isPresent()){
            return person.get();
        }
        else {
            return null;
        }
    }


    public List<Person> findPersonWithOutLicense(){

        return personRepository.findByNoLicense();
    }

}
