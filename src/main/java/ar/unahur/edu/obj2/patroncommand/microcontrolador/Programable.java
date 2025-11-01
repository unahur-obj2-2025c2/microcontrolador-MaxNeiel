package ar.unahur.edu.obj2.patroncommand.microcontrolador;

import ar.unahur.edu.obj2.patroncommand.operaciones.Comando;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

import java.util.List;

public interface Programable {

    void run(List<Operable> operaciones);

    void undoLastOperation();

    void incProgramCounter();

    Integer getProgramCounter();

    void setAcumuladorA(Integer value);

    Integer getAcumuladorA();

    void setAcumuladorB(Integer value);

    Integer getAcumuladorB();

    void setAddr(Integer addr);

    Integer getAddr(Integer addr);

    void reset();

    Programable copiar();

    void copiarDesde(Programable microPrevio);
}