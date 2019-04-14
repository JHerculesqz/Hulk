package com.firelord.spring.component.tmp.security._2_secure._6_encrypt;

import com.firelord.spring.component.tmp.log.LogUtilsExIOC;
import org.apache.tomcat.util.codec.binary.Base64;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.Encryptor;
import org.owasp.esapi.Randomizer;
import org.owasp.esapi.crypto.CipherText;
import org.owasp.esapi.crypto.CipherTextSerializer;
import org.owasp.esapi.crypto.CryptoHelper;
import org.owasp.esapi.crypto.PlainText;
import org.owasp.esapi.errors.EncryptionException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * // 1.1.generateNewMasterSalt<br>
 * EncryptUtilsEx.generateNewMasterSalt();<br>
 * // 1.2.getProvider4Crypto<br>
 * System.out.println(EncryptUtilsEx.getProvider4Crypto().hash("123", "111"));
 * <br>
 * 1.3.getHashPassword and getSalt<br>
 * byte[] arrSalt = EncryptUtilsEx.getSalt();<br>
 * String strRes4getHashPassword = EncryptUtilsEx.getHashPassword("xxxx",
 * arrSalt);<br>
 * // 1.4.encrypt and decrypt<br>
 * String strRes4encrypt = EncryptUtilsEx.encrypt("xxxx");<br>
 * PlainText oRes4encrypt = EncryptUtilsEx.decrypt(strRes4encrypt);<br>
 * // 2.getProvider4Randomizer<br>
 * String strRes4getRandomString =
 * EncryptUtilsEx.getProvider4Randomizer().getRandomString(20,
 * EncoderConstants.CHAR_ALPHANUMERICS);<br>
 * // 3.getProvider4Randomizer<br>
 * String strRes4encodeForBase64 =
 * EncryptUtilsEx.getProvider4Encoder().encodeForBase64("test".getBytes(),
 * false);<br>
 * String strRes4decodeFromBase64 = String
 * .valueOf(EncryptUtilsEx.getProvider4Encoder().decodeFromBase64(
 * strRes4encodeForBase64));<br>
 */
public class EncryptUtilsEx {
    //#region Const

    private static final boolean IS_DUG = true;

    //#endregion

    //#region Construction

    public static EncryptUtilsEx getInstance() {
        return new EncryptUtilsEx();
    }

    //#endregion

    //#region getProvider4Crypto

    //#region generateNewMasterSalt

    public void generateNewMasterSalt() {
        try {
            String encryptAlgorithm = ESAPI.securityConfiguration().getEncryptionAlgorithm();
            int encryptionKeyLength = ESAPI.securityConfiguration().getEncryptionKeyLength();
            String randomAlgorithm = ESAPI.securityConfiguration().getRandomAlgorithm();

            SecureRandom random = SecureRandom.getInstance(randomAlgorithm);
            SecretKey secretKey = CryptoHelper.generateSecretKey(encryptAlgorithm, encryptionKeyLength);
            byte[] raw = secretKey.getEncoded();
            byte[] salt = new byte[20]; // Or 160-bits; big enough for SHA1, but
            // not
            // SHA-256 or SHA-512.
            random.nextBytes(salt);
            String eol = System.getProperty("line.separator", "\n"); // So it
            // works
            // on
            // Windows
            // too.
            System.out.println(eol + "Copy and paste these lines into your ESAPI.properties" + eol);
            System.out.println("#==============================================================");
            String strMasterKey = ESAPI.encoder().encodeForBase64(raw, false);
            System.out.println("Encryptor.MasterKey=" + strMasterKey);
            String strMasterSalt = ESAPI.encoder().encodeForBase64(salt, false);
            System.out.println("Encryptor.MasterSalt=" + strMasterSalt);
            System.out.println("#==============================================================" + eol);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //#endregion

    //#region getProvider4Crypto

    public Encryptor getProvider4Crypto() {
        return ESAPI.encryptor();
    }

    //#endregion

    //#region getHashPassword&getSalt

    public String getHashPassword(String strPwd, byte[] arrSalt) {
        return getHashPassword(strPwd, arrSalt, 5000);
    }

    public String getHashPassword(String strPwd, byte[] arrSalt, int iIterCount) {
        try {
            PBEKeySpec oPBEKeySpec = new PBEKeySpec(strPwd.toCharArray(), arrSalt, iIterCount, 256);
            SecretKeyFactory oSecretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] arrHashed = oSecretKeyFactory.generateSecret(oPBEKeySpec).getEncoded();
            String strRes = Base64.encodeBase64String(arrHashed);
            LogUtilsExIOC.log2File4SecureE("[getHashPassword][EncryptInfo]method:PBKDF2WithHmacSHA1", IS_DUG);
            return strRes;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] getSalt() {
        byte[] arrRes = getSalt(8);
        return arrRes;
    }

    public byte[] getSalt(int iSize) {
        byte[] arrRes = EncryptUtilsEx.getInstance().getProvider4Randomizer().getRandomBytes(iSize);
        return arrRes;
    }

    //#endregion

    //#region encrypt&decrypt

    public String encrypt(String strPlainTxt) {
        try {
            PlainText oPlainText = new PlainText(strPlainTxt);
            CipherText oCipherText = EncryptUtilsEx.getInstance().getProvider4Crypto().encrypt(oPlainText);
            String strRes = getSerialStrFromCipherText(oCipherText);
            LogUtilsExIOC.log2File4SecureE("[encrypt][EncryptInfo]" + oCipherText + "[EncryptRes]" + strRes, IS_DUG);
            return strRes;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String getSerialStrFromCipherText(CipherText oCipherText) {
        // 1.serial
        CipherTextSerializer oCipherTextSerializer = new CipherTextSerializer(oCipherText);
        byte[] arrByte = oCipherTextSerializer.asSerializedByteArray();

        // 2.encodeForBase64
        String strRes = EncryptUtilsEx.getInstance().getProvider4Encoder().encodeForBase64(arrByte, false);
        return strRes;
    }

    public PlainText decrypt(String strCipherText) {
        try {
            CipherText oCipherText = getCipherTextFromSerialStr(strCipherText);
            PlainText oPlainText = EncryptUtilsEx.getInstance().getProvider4Crypto().decrypt(oCipherText);
            return oPlainText;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private CipherText getCipherTextFromSerialStr(String strSerialStr) {
        try {
            // 1.decodeFromBase64
            byte[] arrData = EncryptUtilsEx.getInstance().getProvider4Encoder().decodeFromBase64(strSerialStr);
            // 2.根据arrData,生成oCipherText
            CipherTextSerializer oCipherTextSerializer = new CipherTextSerializer(arrData);
            CipherText oRes = oCipherTextSerializer.asCipherText();
            return oRes;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncryptionException e) {
            e.printStackTrace();
        }
        return null;
    }

    //#endregion

    //#endregion

    //#region getProvider4Randomizer

    public Randomizer getProvider4Randomizer() {
        return ESAPI.randomizer();
    }

    //#endregion

    //#region getProvider4Encoder

    public Encoder getProvider4Encoder() {
        return ESAPI.encoder();
    }

    //#endregion
}
