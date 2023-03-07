package com.abe.templates.services;

import com.abe.templates.models.Person;
import com.abe.templates.repository.PersonRepository;

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
}
