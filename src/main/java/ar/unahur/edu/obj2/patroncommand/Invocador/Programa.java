package ar.unahur.edu.obj2.patroncommand.Invocador;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.operaciones.*;

import java.util.ArrayList;
import java.util.List;

public class Programa {
    List<Operable> operaciones;
    public Programa(){
        operaciones = new ArrayList<>();
    }
    public void agregarOperacionNop() {
        operaciones.add(new Nop());
    }

    public void run(Programable micro) {
        micro.run(operaciones);
    }

    public void agregarOperacionLodv(int val) {
        operaciones.add(new Lodv(val));
    }

    public void agregarOperacionSwap() {
        operaciones.add(new Swap());
    }

    public void agregarOperacionAdd() {
        operaciones.add(new Add());
    }

    public void agregarOperacionStr(int addr) {
        operaciones.add(new Str(addr));
    }

    public void agregarOperacionLod(int addr) {
        operaciones.add(new Lod(addr));
    }
}
