package com.isharipov.homework6_3;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Method> getterMap = new HashMap<>();
        for (Method getter : fromClass.getDeclaredMethods()) {
            if ((getter.getName().startsWith("get")) && (getter.getParameterTypes().length == 0) && (!void.class.equals(getter.getReturnType()))) {
                getterMap.put(getter.getName().substring(3), getter);
            }
        }

        for (Method setter : toClass.getDeclaredMethods()) {
            if (setter.getName().startsWith("set") && setter.getParameterTypes().length == 1) {
                if (getterMap.containsKey(setter.getName().substring(3))) {
                    if (setter.getParameterTypes()[0].isAssignableFrom(getterMap.get(setter.getName().substring(3)).getReturnType())) {
                        System.out.println(setter.getName() + " " + getterMap.get(setter.getName().substring(3)).getName());
                    }
                }
            }
        }
    }
}
