package com.abe.templates.services;

import com.abe.templates.models.Person;
import com.abe.templates.repository.PersonRepository;

import java.util.UUID;

public class PersonService {

        private PersonRepository personRepository;

        public PersonService(PersonRepository personRepository) {
                this.personRepository = personRepository;
        }

        public Person getPerson(String id){
                Person person = personRepository.selectById(id);
                if(person != null) {
                        return person;
                }else {
                        throw new IllegalArgumentException("wew");
                }
        }

        public Person register(String name){
                Person person = new Person(UUID.randomUUID().toString(),name);
                personRepository.Insert(person);

                return person;
        }
}
