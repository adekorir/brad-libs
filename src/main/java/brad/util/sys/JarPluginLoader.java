package brad.util.sys;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarPluginLoader<T> {

    private final List<T> pluginList;

    private JarPluginLoader() {
        super();

        pluginList = new ArrayList<>();
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> JarPluginLoader<T> load(Class<T> clazz, final File dir) throws NullPointerException,
            InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {

        // the plugin loader
        JarPluginLoader<T> jarPluginLoader = new JarPluginLoader<>();
        JarClassLoader classLoader = new JarClassLoader();

        // only register jar files
        FileFilter filter = new JarFileFilter();
        for (File file : dir.listFiles(filter)) {
            classLoader.addFile(file);
            Enumeration<JarEntry> jarEntries = new JarFile(file).entries();

            while (jarEntries.hasMoreElements()) {
                JarEntry jarEntry = jarEntries.nextElement();
                if (jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName().replace("/", ".")
                            .substring(0, jarEntry.getName().indexOf(".class"));

                    Class<?> c = Class.forName(className, true, classLoader);
                    for (Class<?> i : c.getInterfaces()) {
                        if (clazz.getName().equals(i.getName())) {
                            jarPluginLoader.pluginList.add((T) c.newInstance());
                        }
                    }
                }
            }
        }


        return jarPluginLoader;
    }

    public Iterator<T> iterator() {
        return pluginList.iterator();
    }
}
