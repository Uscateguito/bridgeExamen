
package org.example.implementacion;

import org.example.encriptacion.InterfaceEncriptar;

public interface InterfaceMensajeEncriptacion {
    public String EncryptarMensaje(String message, String password)throws Exception;
}