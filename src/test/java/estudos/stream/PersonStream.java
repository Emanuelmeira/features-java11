package estudos.stream;

import java.util.Arrays;
import java.util.List;

public class PersonStream {
    public String name;
    public Integer age;

    public PersonStream(){
    }

    public PersonStream(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public static List<PersonStream> getList(){
        List<PersonStream> list = Arrays.asList(new PersonStream("Emanuel", 20),
                                                new PersonStream("Aline", 25),
                                                new PersonStream("Pedro", 30),
                                                new PersonStream("Carla", 17));
        return list;
    }

    public Integer getAge(){
        return this.age;
    }
}
