package com.isharipov.homework7;

/**
 * Created by Илья on 11.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Plugin loadedPlugin1 = new PluginManager("pluginRootDirectory").load("1", "com.isharipov.homework7.PluginImpl");
        System.out.println(loadedPlugin1.getName());
        Plugin loadedPlugin2 = new PluginManager("pluginRootDirectory").load("2", "com.isharipov.homework7.PluginImpl");
        System.out.println(loadedPlugin2.getName());
    }
}
