package test_p.reflection_test;


import shop.view.View;


import static test_p.reflection_test.Getters.*;


/**
 * Created by eugene on 08.02.15.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        View v = new View();

        getAll(v);
        /*Class c = byte.class;

        View v = new View();
        Class clazz = v.getClass();
        System.out.println(clazz.getName());
        int mods = clazz.getModifiers();
        System.out.println(mods);
        if (Modifier.isPublic(mods)) {
            System.out.println("modifier is Public");
        }
        Method[] fields = clazz.getDeclaredMethods();
        for (Method f : fields) {
            System.out.println(f.getName().toString() + " ");
        }*/


    }

    public static void getAll(Object c) throws IllegalAccessException, NoSuchFieldException {
        Class clazz = c.getClass();
        getFields(clazz);
        getMethods(clazz);


    }
}








