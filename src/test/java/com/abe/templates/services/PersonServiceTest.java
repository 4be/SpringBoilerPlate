package com.abe.templates.services;

import com.abe.templates.models.Person;
import com.abe.templates.repository.PersonRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

        @Mock
        private PersonService personService;

        @Mock
        private PersonRepository personRepository;

        @BeforeEach
        public void setup() {
                personService = new PersonService(personRepository);
        }

        @Test
        void testgetPersonNotFound() {
                Assertions.assertThrows(IllegalArgumentException.class,()->{
                        personService.getPerson("Not Found");
                });
        }

        @Test
        void testGetPersonSuccess() {
                Mockito.when(personRepository.selectById("99"))
                        .thenReturn(new Person("99","daniel"));

                var person  = personService.getPerson("99");

                System.out.println(person);
                Assertions.assertNotNull(person);
        }


}
