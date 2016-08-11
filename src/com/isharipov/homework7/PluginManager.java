package com.isharipov.homework7;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Илья on 11.08.2016.
 */
public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        Plugin plugin = null;
        try {
            File file = new File(System.getProperty("usr.dir")+"\\"+pluginRootDirectory + "\\" + pluginName);
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            CustomClassLoader classLoader = new CustomClassLoader(urls);
            System.out.println(classLoader.loadClass(pluginClassName).getName());
            plugin = (Plugin) classLoader.loadClass(pluginClassName).newInstance();


        } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return plugin;
    }
}
