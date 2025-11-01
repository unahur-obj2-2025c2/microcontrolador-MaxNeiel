package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

import java.util.List;

public class Whnz extends Comando{
    List<Operable> operaciones;

    public Whnz(List<Operable> operaciones) {
        this.operaciones = operaciones;
    }

    @Override
    protected void doExecute(Programable micro) {
        while (micro.getAcumuladorA() != 0){
            micro.run(this.operaciones);
        }
    }
}