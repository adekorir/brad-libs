package brad.util.sys;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class JarClassLoader extends URLClassLoader {

    public JarClassLoader() {
        super(new URL[]{});
    }

    public void addFile(File file) throws IOException {
        if (new JarFileFilter().accept(file))
            addURL(file.toURI().toURL());
    }
}
