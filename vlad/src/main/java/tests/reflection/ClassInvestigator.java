package tests.reflection;


import java.lang.reflect.*;

public class ClassInvestigator {
    public static void getInformation(Object o) throws IllegalAccessException {
        Class clazz = o.getClass();
        System.out.println(checkModifiersOfClass(clazz) + " " + "class " + clazz.getSimpleName() + " {");
        getFields(o);
        System.out.println();
        getConstructors(clazz);
        System.out.println();
        getMethods(clazz);
        System.out.println();

    }


    private static String checkModifiersOfClass(Class clazz) {
        int modifierOfClass = clazz.getModifiers();
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
        if (Modifier.isProtected(modifierOfClass)) {
            return "protected";
        }

        return "";
    }

    private static void getFields(Object o) throws IllegalAccessException {
        Class cl = o.getClass();
        Field[] fields = cl.getDeclaredFields();
        if (fields.length > 0) {
            for (Field f : fields) {
                int mod = f.getModifiers();
                f.setAccessible(true);
                if (Modifier.isPublic(mod)) {
                    if (f.getType().isPrimitive()) {
                        System.out.println("public " + f.getType().getSimpleName() + " " +
                                f.getName() + " = " + f.get(o) + ";");
                    }
                    else {
                        if (f.getType().isAssignableFrom(String.class)) {
                            System.out.println("public " + f.getType().getSimpleName() + " " + f.getName()
                                    + " = " + "''" + f.get(o) +  "''" + ";");}
                        else
                            System.out.println("public " + f.getType().getSimpleName() + " " + f.getName() +
                                    " =" + " new " + f.getType().getSimpleName() + "()" + ";");
                    }
                }
                if (Modifier.isPrivate(mod)) {
                    if (f.getType().isPrimitive()) {
                        System.out.println("private " + f.getType().getSimpleName() + " " + f.getName()
                                + " = " + f.get(o) + ";");
                    }  else {
                        if (f.getType().isAssignableFrom(String.class)) {
                            System.out.println("private " + f.getType().getSimpleName() + " " + f.getName() +
                                    " = " + "''" + f.get(o) +  "''" + ";");}
                        else
                            System.out.println("private " + f.getType().getSimpleName() + " " + f.getName() +
                                    " =" + " new " + f.getType().getSimpleName() + "()" + ";");
                    }
                }
                if (Modifier.isProtected(mod)) {
                    if (f.getType().isPrimitive()) {
                        System.out.println("protected " + f.getType().getSimpleName() + " " + f.getName() +
                                " = " + f.get(o) + ";");
                    }
                    else {
                        if (f.getType().isAssignableFrom(String.class)) {
                            System.out.println("protected " + f.getType().getSimpleName() + " " + f.getName()
                                    + " = " + "''" + f.get(o) +  "''" + ";");}
                        else
                            System.out.println("protected" + f.getType().getSimpleName() + " " + f.getName()
                                    + " =" + " new " + f.getType().getSimpleName() + "()" + ";");
                    }
                }
            }
        }

    }

    private static void getMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        if (methods.length > 0) {
            for (Method m : methods) {
                int mod = m.getModifiers();
                Parameter[] parameters = m.getParameters();

                if (Modifier.isPublic(mod)) {
                    if (parameters.length == 0) {
                        System.out.println("public " + m.getReturnType().getSimpleName()+ " " + m.getName() + "(){};");
                    }
                    if (parameters.length == 1) {
                        System.out.println("public " + m.getReturnType().getSimpleName() +
                                " " + m.getName() + " (" + parameters[0].getType().getSimpleName()
                                + " " + parameters[0].getName() + "){};");
                    }
                    if (parameters.length > 1) {
                        System.out.print("public " + m.getReturnType().getSimpleName() +
                                " " + m.getName() + " (");
                        for (Parameter p : parameters) {
                            System.out.print(p.getType().getSimpleName() + " " + p.getName() + ", ");
                        }
                        System.out.println("){};");
                    }
                }
                if (Modifier.isPrivate(mod)) {
                    if (parameters.length == 0) {
                        System.out.println("private " + m.getReturnType().getSimpleName() + " " + m.getName() + "(){};");
                    }
                    if (parameters.length == 1) {
                        System.out.println("private " + m.getReturnType().getSimpleName() +
                                " " + m.getName() + " (" + parameters[0].getType().getSimpleName()
                                + " " + parameters[0].getName() + "){};");
                    }
                    if (parameters.length > 1) {
                        System.out.print("private " + m.getReturnType().getSimpleName() +
                                " " + m.getName() + " (");
                        for (Parameter p : parameters) {
                            System.out.print(p.getType().getSimpleName() + " " + p.getName() + ", ");
                        }
                        System.out.println("){};");
                    }


                }
                if (Modifier.isProtected(mod)) {
                    if (parameters.length == 0) {
                        System.out.println("protected " + m.getReturnType().getSimpleName() + " " + m.getName() + "(){};");
                    }
                    if (parameters.length == 1) {
                        System.out.println("protected " + m.getReturnType().getSimpleName() +
                                " " + m.getName() + " (" + parameters[0].getType().getSimpleName()
                                + " " + parameters[0].getName() + "){};");
                    }
                    if (parameters.length > 1) {
                        System.out.print("protected " + m.getReturnType().getSimpleName() +
                                " " + m.getName() + " (");
                        for (Parameter p : parameters) {
                            System.out.print(p.getType().getSimpleName() + " " + p.getName() + ", ");
                        }
                        System.out.println("){};");
                    }
                }
            }
        }
    }


    private static void getConstructors(Class cl){
        Constructor[] constructors = cl.getConstructors();
        if (constructors.length > 0) {
            for (Constructor c : constructors) {
                int mod = c.getModifiers();
                Parameter[] parameters = c.getParameters();

                if (Modifier.isPublic(mod)) {
                    if (parameters.length == 0) {
                        System.out.println("public " + c.getDeclaringClass().getSimpleName() + "(){};");
                    }
                    if (parameters.length == 1) {
                        System.out.println("public " + c.getDeclaringClass().getSimpleName()  + "(" + parameters[0].getType().getSimpleName()
                                + " " + parameters[0].getName() + "){};");
                    }
                    if (parameters.length > 1) {
                        System.out.print("public " + c.getDeclaringClass().getSimpleName() + "(");
                        for (Parameter p : parameters) {
                            System.out.print(p.getType().getSimpleName()  + " " + p.getName() + ", ");
                        }
                        System.out.println("){};");
                    }
                }
                if (Modifier.isPrivate(mod)) {
                    if (parameters.length == 0) {
                        System.out.println("private " +c.getDeclaringClass().getSimpleName()  + "(){};");
                    }
                    if (parameters.length == 1) {
                        System.out.println("private " + c.getDeclaringClass().getSimpleName()  + "(" + parameters[0].getType().getSimpleName()
                                + " " + parameters[0].getName() + "){};");
                    }
                    if (parameters.length > 1) {
                        System.out.print("private " + c.getDeclaringClass().getSimpleName() + "(");
                        for (Parameter p : parameters) {
                            System.out.print(p.getType().getSimpleName() + " " + p.getName() + ", ");
                        }
                        System.out.println("){};");
                    }


                }
                if (Modifier.isProtected(mod)) {
                    if (parameters.length == 0) {
                        System.out.println("protected " +c.getDeclaringClass().getSimpleName()  + "(){};");
                    }
                    if (parameters.length == 1) {
                        System.out.println("protected " +c.getDeclaringClass().getSimpleName()  + "(" + parameters[0].getType().getSimpleName()
                                + " " + parameters[0].getName() + "){};");
                    }
                    if (parameters.length > 1) {
                        System.out.print("protected " +c.getDeclaringClass().getSimpleName()  + "(");
                        for (Parameter p : parameters) {
                            System.out.print(p.getType().getSimpleName() + " " + p.getName() + ", ");
                        }
                        System.out.println("){};");
                    }
                }
            }
        }
    }

}
