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
        return super.loadClass(name);
    }
}
