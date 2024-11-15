# Documentación del Repositorio PatronBridge

## Descripción

El repositorio PatronBridge implementa el patrón de diseño Bridge en Java. Este patrón permite separar la abstracción de su implementación, de modo que ambos puedan variar de forma independiente. En este caso, se aplica para el proceso de encriptación de mensajes, ofreciendo diferentes algoritmos de encriptación como AES, DES y Base64, además de la opción de no encriptar.

## Estructura del Proyecto

El proyecto está estructurado de la siguiente manera:

- `src/main/java/org/example/patronbridge`: Contiene el código fuente del proyecto.
  - `PatronBridgeMain.java`: Clase principal que ejecuta ejemplos de encriptación.
  - `implementacion`: Contiene la implementación del puente (`PuenteMensajeEncriptacion.java`) que conecta la abstracción con las implementaciones concretas.
  - `encriptacion`: Contiene las implementaciones concretas de los algoritmos de encriptación (`ProcesoEncriptarAES.java`, `ProcesoEncriptarDES.java`, `ProcesoEncriptarBase64.java`, `ProcesoSinEncriptar.java`).
  - `InterfaceMensajeEncriptacion.java`: Define la abstracción para el proceso de encriptación.
  - `InterfaceEncriptar.java`: Define la interfaz para las implementaciones concretas de encriptación.
- `.idea`: Contiene archivos de configuración específicos de IntelliJ IDEA.
- `pom.xml`: Archivo de configuración de Maven para la gestión de dependencias y construcción del proyecto.

## Cómo Usar

Para utilizar este proyecto, se debe tener instalado Java y Maven. Luego, se puede clonar el repositorio y ejecutar el proyecto con los siguientes comandos:

```bash
git clone https://github.com/davidfer1112/patronbridge.git
cd patronbridge
mvn compile
mvn exec:java -Dexec.mainClass="org.example.patronbridge.PatronBridgeMain"
```

Esto ejecutará la clase `PatronBridgeMain`, la cual demostrará la encriptación de un mensaje de prueba utilizando diferentes algoritmos.

##Ejemplo de Uso

En el archivo `PatronBridgeMain.java`, se crea una instancia de `PuenteMensajeEncriptacion` para cada tipo de encriptación soportada y luego se encripta un mensaje de ejemplo con cada una:

```java
public static void main(String[] args) {
    InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());
    InterfaceMensajeEncriptacion FormatoDES = new PuenteMensajeEncriptacion(new ProcesoEncriptarDES());
    InterfaceMensajeEncriptacion FormatoBase64 = new PuenteMensajeEncriptacion(new ProcesoEncriptarBase64());
    InterfaceMensajeEncriptacion SinFormato = new PuenteMensajeEncriptacion(new ProcesoSinEncriptar());

    try {
        final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
        String messageAES = FormatoAES.EncryptarMensaje(message, "HG58YZ3CR9123456");
        System.out.println("Formato AES > " + messageAES + "\n");

        String messageDES = FormatoDES.EncryptarMensaje(message, "XMzDdG4D03CKm2Ix");
        System.out.println("Formato DES > " + messageDES + "\n");

        String messageBase64 = FormatoBase64.EncryptarMensaje(message, null);
        System.out.println("Formato Base64 > " + messageBase64 + "\n");

        String messageNO = SinFormato.EncryptarMensaje(message, null);
        System.out.println("Sin Formato > " + messageNO + "\n");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

```

## Conclusión
El repositorio PatronBridge es un ejemplo práctico de cómo implementar el patrón de diseño Bridge en Java para separar la abstracción de la implementación en el contexto de la encriptación de mensajes. Permite la fácil extensión del sistema para soportar nuevos algoritmos de encriptación sin modificar el código cliente.
# bridgeExamen
