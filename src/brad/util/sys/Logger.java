package brad.util.sys;

public interface Logger extends Initializable {
    void log(Severity severity, String message);

    enum Severity {
        DEBUG("DEBUG"), INFO("INFOR"), ERROR("ERROR"), CRITICAL("CRITI"), EXCEPTION("EXCEP");

        private String toString;

        Severity(String str) {
            toString = str;
        }

        @Override
        public String toString() {
            return toString;
        }
    }
}
