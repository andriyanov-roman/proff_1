package test.io.reflection;

import com.sun.java.util.jar.pack.*;
import shop.View;

import java.io.IOException;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {

//        Class cl = view.getClass();
//        int mods = cl.getModifiers();
//        if (Modifier.isPrivate(mods)) {
//            System.out.println("le");
//        }
//        Field[] fields = cl.getFields();
//
//        for (Field f : fields) {
//            Class clazz = f.getType();
//            System.out.println(f.getName() + " " + clazz.getName());
//        }
//        Field[] privateFields = cl.getDeclaredFields();
//        for (Field f : privateFields) {
//            System.out.println(f.getName() + " ");}
        View v = new View();
        Class clazz = v.getClass();
        getClassName(clazz);
        getFieldName(clazz);
        getMethodsName(clazz);
    }

    public static void getClassName(Class clazz) {
        Class c = clazz;
        //System.out.println(checkModifiers(clazz) + " " + "class " + clazz.getSimpleName() + " {");
    }

    public static void getFieldName(Class clazz) throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Class classField = f.getType();
            System.out.println(checkModifiers(f) + " " + classField.getSimpleName() + " " + f.getName()+" ");
            //System.out.println(field.getSimpleName());
        }
    }

    public static void getMethodsName(Class clazz) {
        Method[] method=clazz.getDeclaredMethods();
        for(Method m:method){
            System.out.println(checkModifiers(m)+" "+m.getName()+" ");
        }
    }

    public static void getConstructor(Class clazz){
        Constructor[] constructors=clazz.getDeclaredConstructors();
        for(Constructor c:constructors){
            System.out.println(c.getName());
        }
    }
    public static String checkModifiers(Member f) {
        int modifierOfClass = f.getModifiers();
        if (Modifier.isPublic(modifierOfClass)) {
            return "public";
        }
        if (Modifier.isPrivate(modifierOfClass)) {
            return "private";
        }
        if (Modifier.isAbstract(modifierOfClass)) {
            return "abstract";
        }
        if (Modifier.isFinal(modifierOfClass)) {
            return "final";
        }
        return "";
    }

}
