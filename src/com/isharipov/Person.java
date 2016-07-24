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
            if (this.spouse != null) {
                this.divorce();
            } else if (person.spouse != null) {
                person.divorce();
            }
            this.spouse = person;
            person.spouse = this;
            return true;
        }
        return false;
    }

    public boolean divorce() {
        this.getSpouse().spouse = null;
        this.spouse = null;
        return true;
    }
}
