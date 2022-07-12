package com.slimeIdle.Model;

public class Encryption {

    public com.slimeIdle.Model.AES AES = new AES();
    private String encryptionKeyBase64 = "DJIzFkO22qfVMgX2fIsxOXNwz25pDBZfFJBvf4RS4eZ=";
    private String ivBase64 = "AkxkMwikMkW4c7+mHtztfw==";

    public String getEncryptionKeyBase64() {
        return encryptionKeyBase64;
    }
    public void setEncryptionKeyBase64(String encryptionKeyBase64) {
        this.encryptionKeyBase64 = encryptionKeyBase64;
    }

    public String getIvBase64() {
        return ivBase64;
    }
    public void setIvBase64(String ivBase64) {
        this.ivBase64 = ivBase64;
    }

    public String encrypt(String encryptStr) {
        try {
            encryptStr = AES.encrypt(encryptStr, getEncryptionKeyBase64(), getIvBase64());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptStr;
    }

    public String decrypt(String decryptStr) {
        try {
            decryptStr = AES.decrypt(decryptStr, getEncryptionKeyBase64(), getIvBase64());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptStr;
    }

    public String[] encryptIn2(String plainString) {
        final int mid = plainString.length() / 2;
        String[] parts = {plainString.substring(0, mid),plainString.substring(mid)};
        try
        {
            parts[0] = AES.encrypt(parts[0], getEncryptionKeyBase64(), getIvBase64());
            parts[1] = AES.encrypt(parts[1], getEncryptionKeyBase64(), getIvBase64());

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        return parts;
    }
}
