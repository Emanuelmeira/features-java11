package estudos.stream;

import java.util.Objects;

public class Person {
    public String name;
    public Integer age;
    public boolean active;

    public Person(){

    }

    public Person(String name, Integer age, boolean active){
        this.name = name;
        this.age = age;
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return active == person.active &&
                Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, active);
    }
}
