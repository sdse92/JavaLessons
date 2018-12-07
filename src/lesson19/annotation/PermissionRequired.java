package lesson19.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//описание
//@Target() указывает на сферу ответственности аннотации
//METHOD
//CONSTRUCTOR
//FIELD
//@Target(ElementType.FIELD) аннотация применяется к типу

//@Retention(RetentionPolicy.RUNTIME) //указывает как долго хранить аннотацию PermissionRequired

public @interface PermissionRequired {
    User.Permission value(); //могут возвращать String, примитивы, enum
}
