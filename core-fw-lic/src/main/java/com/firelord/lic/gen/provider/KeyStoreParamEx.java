package com.firelord.lic.gen.provider;

import de.schlichtherle.license.AbstractKeyStoreParam;

import java.io.*;

/**
 * KeyStoreParamEx
 */
public class KeyStoreParamEx extends AbstractKeyStoreParam {
    //#region Fields

    private String storePath;
    private String alias;
    private String storePwd;
    private String keyPwd;

    //#endregion

    //#region Construction

    public KeyStoreParamEx(Class clazz, String resource, String alias, String storePwd, String keyPwd) {
        super(clazz, resource);
        this.storePath = resource;
        this.alias = alias;
        this.storePwd = storePwd;
        this.keyPwd = keyPwd;
    }

    //#endregion

    //#region getAlias

    @Override
    public String getAlias() {
        return alias;
    }

    //#endregion

    //#region getStorePwd

    @Override
    public String getStorePwd() {
        return storePwd;
    }

    //#endregion

    //#region getKeyPwd

    @Override
    public String getKeyPwd() {
        return keyPwd;
    }

    //#endregion

    //#region getStream

    @Override
    public InputStream getStream() throws IOException {
        final InputStream in = new FileInputStream(new File(storePath));
        if (null == in) {
            throw new FileNotFoundException(storePath);
        }

        return in;
    }

    //#endregion
}
