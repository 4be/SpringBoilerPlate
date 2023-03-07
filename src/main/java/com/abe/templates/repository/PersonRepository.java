package com.abe.templates.repository;

import com.abe.templates.models.Person;

public interface PersonRepository {

        Person selectById(String id);
}
