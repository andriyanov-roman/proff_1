package tests.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface MyAnnotation {
    String name();
    int value();
}
