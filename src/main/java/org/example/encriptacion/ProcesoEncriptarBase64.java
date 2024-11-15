package org.example.encriptacion;

import java.util.Base64;

public class ProcesoEncriptarBase64 implements InterfaceEncriptar {

    @Override
    public String encryptar(String message, String password) throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(message.getBytes());
        return encodedString;
    }
}
