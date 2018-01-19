package brad.util.sys;

import java.io.File;
import java.io.FileFilter;

public class JarFileFilter implements FileFilter {

    public JarFileFilter() {
        super();
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".jar");
    }
}
