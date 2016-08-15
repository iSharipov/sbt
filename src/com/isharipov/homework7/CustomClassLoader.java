package com.isharipov.homework7;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Илья on 11.08.2016.
 */
public class CustomClassLoader extends URLClassLoader {
    public CustomClassLoader(URL[] urls) throws MalformedURLException {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.contains("com.isharipov.homework7.Plugin") || name.startsWith("java")) {
            return super.loadClass(name);
        } else return findClass(name);
    }
}
