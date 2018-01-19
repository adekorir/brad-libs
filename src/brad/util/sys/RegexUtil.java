package brad.util.sys;

public interface RegexUtil {
    String PHONE_EAST_AFRICA = "^(0|\\+?25[3-6]{1})([3-8]{1}[0-9]{2})([0-9]{3})([0-9]{3})";   // east african telephone no
    String ZIP = "^(?!01000|99999)(0[1-9]\\d{3}|[1-9]\\d{4})$"; // kenyan style zip code ie 00000 and 99999 are illegal
    // todo get the regex for emails at http://emailregex.com/
}
