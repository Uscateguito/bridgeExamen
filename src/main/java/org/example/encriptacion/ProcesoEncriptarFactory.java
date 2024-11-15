package org.example.encriptacion;

import java.io.InputStream;
import java.util.Properties;

// En este método estoy haciendo uso de un archivo de configuración para determinar el tipo de encriptación que se va a utilizar.
public class ProcesoEncriptarFactory {

    public static InterfaceEncriptar crearProcesoEncriptar() {
        Properties propiedades = new Properties();
        try (InputStream input = ProcesoEncriptarFactory.class.getClassLoader().getResourceAsStream("config.txt")) {
            if (input == null) {
                throw new RuntimeException("No se encontró el archivo de configuración.");
            }
            propiedades.load(input);
            String tipoEncriptacion = propiedades.getProperty("metodo_encriptacion");
            System.out.println("Tipo de encriptación: " + tipoEncriptacion);

            switch (tipoEncriptacion) {
                case "AES":
                    return new ProcesoEncriptarAES();
                case "DES":
                    return new ProcesoEncriptarDES();
                case "Base64":
                    return new ProcesoEncriptarBase64();
                case "SinFormato":
                    return new ProcesoSinEncriptar();
                default:
                    throw new IllegalArgumentException("Tipo de encriptación desconocido: " + tipoEncriptacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

