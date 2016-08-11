package com.isharipov.homework7;

/**
 * Created by Илья on 11.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Plugin plugin = new PluginImpl("New Plugin");
        System.out.println(System.getProperty("user.dir"));
        Plugin loadedPlugin = new PluginManager("pluginRootDirectory").load("1", "com.isharipov.homework7.PluginImpl");
        System.out.println(loadedPlugin.getName());
    }
}
