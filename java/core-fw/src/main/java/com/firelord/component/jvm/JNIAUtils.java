package com.firelord.component.jvm;

import com.sun.jna.Native;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * JNIAUtils
 */
public class JNIAUtils {
    //#region getDllInJarFilePath

    public static String getDllInJarFilePath(String strDllName, Class<?> oClazz) throws IOException {
        //gen oFileTmp
        File oFileTmp = File.createTempFile(strDllName, "");
        FileOutputStream oFileOutputStream = new FileOutputStream(oFileTmp);

        //read dll in jar
        InputStream oInputStream = oClazz.getResourceAsStream(strDllName);
        byte[] arrBuffer = new byte[1024];
        int iRead;
        while ((iRead = oInputStream.read(arrBuffer)) != -1) {
            oFileOutputStream.write(arrBuffer, 0, iRead);
        }
        oFileOutputStream.close();
        oInputStream.close();

        //return
        return oFileTmp.getAbsolutePath();
    }

    //#endregion

    //#region load4JNI

    public static void load4JNI(String strDllName, Class<?> oClazz) {
        try {
            //get strFilePath
            String strFilePath = getDllInJarFilePath(strDllName, oClazz);

            //load
            System.load(strFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //#endregion

    //#region load4JNA

    public static Object load4JNA(String strDllName, Class<?> oClazz,
                                  Class<?> oLibInterfaceClazz) {
        try {
            //get strFilePath
            String strFilePath = getDllInJarFilePath(strDllName, oClazz);

            //load
            Object oLibInterface = Native.loadLibrary(strFilePath, oLibInterfaceClazz);

            return oLibInterface;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //#endregion
}
