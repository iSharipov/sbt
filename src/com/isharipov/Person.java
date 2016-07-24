package com.isharipov;

/**
 * Created by Илья on 24.07.2016.
 */
public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public boolean marry(Person person) {
        if (this.isMan() != person.isMan()) {
            if (this.getSpouse() != null || person.getSpouse() != null) {
                if (divorce(this, person)) {
                    this.spouse = person;
                    person.spouse = this;
                    return true;
                } else {
                    return false;
                }
            } else {
                this.spouse = person;
                person.spouse = this;
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean divorce(Person person, Person anotherPerson) {
        if (person.getSpouse() != null) {
            person.getSpouse().spouse = null;
            person.spouse = null;
        } else if (anotherPerson.getSpouse() != null) {
            anotherPerson.getSpouse().spouse = null;
            anotherPerson.spouse = null;
        }
        return true;
    }
}

