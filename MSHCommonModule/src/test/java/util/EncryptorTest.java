package util;

import org.junit.Test;

/**
 * Created by Kray on 2016/12/21.
 */
public class EncryptorTest {

    @Test
    public void testEncryptor(){
        String s = "songkuixi";
        Encryptor.encrypt(s);
    }
}
