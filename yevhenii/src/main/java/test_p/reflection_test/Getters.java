package test_p.reflection_test;

import shop.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by eugene on 11.02.15.
 */
public class Getters {
    public static void getFields(Class clazz) throws NoSuchFieldException, IllegalAccessException {

        Field[] fields = clazz.getDeclaredFields();
        int mods = clazz.getModifiers();
        if (Modifier.isPublic(mods)) {
            System.out.println("public" + " class " + clazz.getSimpleName() + "{");
        }
        if (Modifier.isPrivate(mods)) {
            System.out.println("private " + " class " + clazz.getSimpleName() + "{");
        }
        if (Modifier.isProtected(mods)) {
            System.out.println("protected " + " class " + clazz.getSimpleName() + "{");
        }
        View v = new View();
        for (Field f : fields) {
            int mod = f.getModifiers();
            String s = String.valueOf(f.getName());
            Field x = clazz.getDeclaredField(s);
            x.setAccessible(true);
            if (Modifier.isPublic(mod)) {
                if (!x.getType().isPrimitive()) {
                    if (x.getType().getSimpleName().equalsIgnoreCase("string")) {
                        System.out.println("public " + " " + x.getType().getSimpleName() + " " + x.getName() + " = " + " '' " + x.get(v) + "''" + ";");
                    } else {
                        System.out.println("public " + " " + x.getType().getSimpleName() + " " + x.getName() + " =" + " new " + x.getType().getSimpleName() + "()" + ";");

                    }
                }
                if (x.getType().isPrimitive()) {


                    System.out.println("public " + " " + x.getType().getSimpleName() + " " + x.getName() + " = " + x.get(v) + ";");
                }
            }
            if (Modifier.isPrivate(mod)) {
                if (!x.getType().isPrimitive()) {
                    if (x.getType().getSimpleName().equalsIgnoreCase("string")) {
                        System.out.println("private " + " " + x.getType().getSimpleName() + " " + x.getName() + " = " + " '' " + x.get(v) + "''" + ";");
                    } else {
                        System.out.println("private " + " " + x.getType().getSimpleName() + " " + x.getName() + " =" + " new " + x.getType().getSimpleName() + "()" + ";");

                    }
                }
                if (x.getType().isPrimitive()) {


                    System.out.println("private " + " " + x.getType().getSimpleName() + " " + x.getName() + " = " + x.get(v) + ";");
                }
            }
            if (Modifier.isProtected(mod)) {
                if (!x.getType().isPrimitive()) {
                    if (x.getType().getSimpleName().equalsIgnoreCase("string")) {
                        System.out.println("protected " + " " + x.getType().getSimpleName() + " " + x.getName() + " = " + " '' " + x.get(v) + "''" + ";");
                    } else {
                        System.out.println("protected " + " " + x.getType().getSimpleName() + " " + x.getName() + " =" + " new " + x.getType().getSimpleName() + "()" + ";");

                    }
                }
                if (x.getType().isPrimitive()) {


                    System.out.println("protected " + " " + x.getType().getSimpleName() + " " + x.getName() + " = " + x.get(v) + ";");
                }
            }
        }


    }
    public static void getMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            int mod = m.getModifiers();
            if (Modifier.isPublic(mod)) {
                System.out.println("public " + " " + m.getReturnType() + " " + m.getName() + "{" + ";");
            }
            if (Modifier.isPrivate(mod)) {
                System.out.println("private " + " " + m.getReturnType() + " " + m.getName() + "()" + ";");
            }
            if (Modifier.isProtected(mod)) {
                System.out.println("protected " + " " + m.getReturnType() + " " + m.getName() + "()" + ";");
            }

        }
    }
    public static void getMethBody(Method m){

    }
}
