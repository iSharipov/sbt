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

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getPerson() {
        return this;
    }

    public boolean marry(Person person) {
        if (this.isMan() != person.isMan()) {
            if (this.getSpouse() != null || person.getSpouse() != null) {
                if (divorce(this, person)) {
                    this.spouse = person;
                    person.setSpouse(this);
                    return true;
                } else {
                    return false;
                }
            } else {
                this.spouse = person;
                person.setSpouse(this);
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean divorce(Person person, Person anotherPerson) {
        if (person.getSpouse() != null) {
            person.getSpouse().getPerson().setSpouse(null);
            person.setSpouse(null);
        } else if (anotherPerson.getSpouse() != null) {
            anotherPerson.getSpouse().getPerson().setSpouse(null);
            anotherPerson.setSpouse(null);
        }
        return true;
    }
}

