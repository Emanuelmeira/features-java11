package estudos.poo.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // defique que essa @ sera apenas usada em metodos (FIELD para atributos da class)
@Retention(RetentionPolicy.RUNTIME) // define que a @ sera usada em tempo de execução (@Override funciona em tempo de compilação)
//Reflection funciona apenas em anotações que tenham sido marcadas com @Retention.RUNTIME.
public @interface Mostrar {}
