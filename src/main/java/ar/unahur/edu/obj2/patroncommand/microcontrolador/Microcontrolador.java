package ar.unahur.edu.obj2.patroncommand.microcontrolador;

import ar.unahur.edu.obj2.patroncommand.operaciones.Comando;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

import java.util.Arrays;
import java.util.List;

public class Microcontrolador implements Programable {
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer programCounter = 0;
    private List<Integer> memoria = Arrays.asList(new Integer[1024]);
    private Operable lastOperation = null;

    @Override
    public void run(List<Operable> operaciones) {
        lastOperation = operaciones.getLast();
        operaciones.forEach(op -> op.execute(this));
    }

    @Override
    public void undoLastOperation() {
        lastOperation.undo(this);
    }

    @Override
    public void incProgramCounter() {
        programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }

    @Override
    public void setAddr(Integer addr) {
        if (addr >= memoria.size() || addr < 0) {
            throw new IllegalArgumentException("El valor de memoria es invalido. ");
        }
        else {
            memoria.set(addr, acumuladorA);
        }

    }

    @Override
    public Integer getAddr(Integer addr) {
        return memoria.get(addr);
    }

    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        memoria.clear();
    }

    @Override
    public Programable copiar() {
        Microcontrolador copia = new Microcontrolador();
        copia.acumuladorA = this.acumuladorA;
        copia.acumuladorB = this.acumuladorB;
        copia.programCounter = this.programCounter;
        return copia;
    }

    @Override
    public void copiarDesde(Programable microPrevio) {
        programCounter = microPrevio.getProgramCounter();
        acumuladorA = microPrevio.getAcumuladorA();
        acumuladorB = microPrevio.getAcumuladorB();
    }
}
