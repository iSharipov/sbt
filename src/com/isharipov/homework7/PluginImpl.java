package com.isharipov.homework7;

/**
 * Created by Илья on 11.08.2016.
 */
public class PluginImpl implements Plugin {
    private String name = "Sbt";

    public PluginImpl() {

    }

    public PluginImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
