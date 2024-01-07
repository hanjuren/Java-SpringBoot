package hello.jwt_example.common.util;

import org.mindrot.jbcrypt.BCrypt;

public class BcryptUtil {
    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean isMatch(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
