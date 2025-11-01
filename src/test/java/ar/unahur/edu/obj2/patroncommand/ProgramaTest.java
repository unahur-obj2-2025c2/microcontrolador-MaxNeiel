package ar.unahur.edu.obj2.patroncommand;

import ar.unahur.edu.obj2.patroncommand.Invocador.Programa;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.operaciones.Swap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgramaTest {

    @Test
    public void Avanzar3PosicionesElProgramCounter(){
        Programa programa = new Programa();
        Programable micro = new Microcontrolador();

        programa.agregarOperacionNop();
        programa.agregarOperacionNop();
        programa.agregarOperacionNop();

        programa.run(micro);

        assertEquals(3, micro.getProgramCounter());

    }

    @Test
    public void sumar20y17(){
        Programa programa = new Programa();
        Programable micro = new Microcontrolador();

        programa.agregarOperacionLodv(20);
        programa.agregarOperacionSwap();
        programa.agregarOperacionLodv(17);
        programa.agregarOperacionAdd();

        programa.run(micro);

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());

    }

    @Test
    public void sumar2y8y5(){
        Programa programa = new Programa();
        Programable micro = new Microcontrolador();

        programa.agregarOperacionLodv(2);
        programa.agregarOperacionStr(0);
        programa.agregarOperacionLodv(8);
        programa.agregarOperacionSwap();
        programa.agregarOperacionLodv(5);
        programa.agregarOperacionAdd();
        programa.agregarOperacionSwap();
        programa.agregarOperacionLod(0);
        programa.agregarOperacionAdd();

        programa.run(micro);

        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(9, micro.getProgramCounter());
    }

    @Test
    public void VuelveAValoresPreviosAlDeshacer(){
        Programa programa = new Programa();
        Programable micro = new Microcontrolador();

        programa.agregarOperacionLodv(10);
        programa.agregarOperacionSwap();
        programa.agregarOperacionLodv(20);

        programa.run(micro);

        Integer valAcumuladorAprevio =  micro.getAcumuladorA();
        Integer valAcumuladorBprevio =  micro.getAcumuladorB();

        programa.agregarOperacionSwap();
        programa.run(micro);

        micro.undoLastOperation();

        assertEquals(valAcumuladorAprevio, micro.getAcumuladorA());
    }
}
