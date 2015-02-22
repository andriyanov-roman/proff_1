package test.io.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface NewAnnotation {
    String name();
    int value();
}
