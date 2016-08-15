package com.brianway.learning.spring.ioc.placeholder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by brian on 16/6/22.
 * DES加密工具类
 * TODO 解密在linux下有bug,参考:
 * http://blog.csdn.net/rj042/article/details/8196125
 * http://my.oschina.net/skyfree/blog/62370
 */
public class DESUtils {
    //指定DES加密所用的密钥
    private static Key key;
    private static String KEY_STR = "brianway";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KEY_STR.getBytes());
            generator.init(secureRandom);
            key = generator.generateKey();
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //对字符串进行DES加密,返回BASE64编码的加密字符串
    public static String getEncryptString(String str) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            byte[] strBytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return base64Encoder.encode(encryptStrBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //对BASE64编码的加密字符串进行解密,返回解密后的字符串
    public static String getDecryptString(String str) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] strBytes = base64Decoder.decodeBuffer(str);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            return new String(decryptStrBytes, "UTF8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //对入参的字符串进行加密,打印出加密后的串
    public static void main(String[] args) {

    }
}
