package org.example.patronbridge;

import org.example.encriptacion.InterfaceEncriptar;
import org.example.encriptacion.ProcesoEncriptarFactory;
import org.example.implementacion.PuenteMensajeEncriptacion;
import org.example.implementacion.InterfaceMensajeEncriptacion;


public class PatronBridgeMain {
    public static void main(String[] args) {
        
        // A partir del factory, se elige el proceso de encriptación que va a entrar en el bridge
        InterfaceEncriptar procesoEncriptacion = ProcesoEncriptarFactory.crearProcesoEncriptar();
        
        // Cree el bridge con el proceso de encriptación

        if (procesoEncriptacion != null) {
            InterfaceMensajeEncriptacion mensajeEncriptacion = new PuenteMensajeEncriptacion(procesoEncriptacion);
            
            try {
                String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
                // La contraseña es con 16 caracteres por el AES
                String mensajeEncriptado = mensajeEncriptacion.EncryptarMensaje(message, "ClaveSegura12345");
                System.out.println("Mensaje Encriptado > " + mensajeEncriptado);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se pudo crear el proceso de encriptación.");
        }
    }
}
