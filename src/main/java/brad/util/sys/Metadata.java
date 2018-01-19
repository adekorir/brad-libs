package brad.util.sys;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Metadata {
    String id();

    String name();

    String menuItemText() default "";

    String author() default "BA Systems Ltd.";

    String version() default "1.0.0";

    String description() default "N/A";

    String icon() default "location-icon.png";
}