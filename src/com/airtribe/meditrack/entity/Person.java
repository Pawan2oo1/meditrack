package com.airtribe.meditrack.entity;

import com.airtribe.meditrack.interfaces.Searchable;
import com.airtribe.meditrack.util.Validator;

public abstract class Person implements Searchable {
    protected int id;
    protected String name;
    protected int age;

    protected Person(String name, int age) {
        if (!Validator.isValidName(name)) {
            this.name = "INVALID_NAME";
        } else {
            this.name = name;
        }
        if (!Validator.isValidAge(age)) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public abstract boolean matches(String criteria);
}
