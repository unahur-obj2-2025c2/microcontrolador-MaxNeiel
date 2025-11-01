package ar.unahur.edu.obj2.patroncommand;

import ar.unahur.edu.obj2.patroncommand.Invocador.Programa;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {
    @Test
    public void lanzaExcepcionAlUsarUnAddressInvalido(){
        Programa programa = new Programa();
        Programable micro = new Microcontrolador();

        programa.agregarOperacionStr(1024);
        
        assertThrows(IllegalArgumentException.class, ()->programa.run(micro));
    }
}
