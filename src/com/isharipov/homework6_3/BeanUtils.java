package com.isharipov.homework6_3;

import java.lang.reflect.Method;

/**
 * Created by Илья on 08.08.2016.
 */
public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static <T> void assign(T to, T from) throws NoSuchMethodException {
        Class fromClass = from.getClass();
        Class toClass = to.getClass();
        for (Method getter : fromClass.getDeclaredMethods()) {
            if ((getter.getName().startsWith("get"))
                    && (getter.getParameterTypes().length == 0)
                    && (!void.class.equals(getter.getReturnType()))) {
                Method setter;
                try {
                    setter = toClass.getDeclaredMethod("set" + getter.getName().substring(3), getter.getReturnType());
                } catch (NoSuchMethodException e) {
                    setter = toClass.getDeclaredMethod("set" + getter.getName().substring(3), getter.getReturnType().getSuperclass());
                }

                if (setter.getParameterTypes().length == 1) {
                    System.out.println(getter.getName() + " " + setter.getName());
                }
            }
        }
    }
}
