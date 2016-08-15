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
            String strToUrl = new StringBuilder(System.getProperty("user.dir"))
                    .append("/")
                    .append(pluginRootDirectory)
                    .append("/")
                    .append(pluginName).toString();

            File file = new File(strToUrl);
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader urlClassLoader = new CustomClassLoader(urls);
            plugin = (Plugin) urlClassLoader.loadClass(pluginClassName).newInstance();
        } catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return plugin;
    }
}
