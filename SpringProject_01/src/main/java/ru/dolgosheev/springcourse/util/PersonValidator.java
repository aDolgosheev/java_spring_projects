package ru.dolgosheev.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.dolgosheev.springcourse.dao.PersonDAO;
import ru.dolgosheev.springcourse.models.Person;


public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PersonDAO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (personDAO.getPersonByFullName(person.getFullName()).isPresent())
            errors.rejectValue("fullName", "", "Person with same name is already here");
    }
}
