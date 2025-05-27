package usecase;

import input.ICrearPilotoInput;
import model.Piloto;
import output.ICrearPilotoOutput;

public class CrearPilotoUseCase implements ICrearPilotoInput {

    ICrearPilotoOutput crearPilotoOutput;

    @Override
    public boolean crearPiloto(Piloto piloto) {
        return crearPilotoOutput.guardarPiloto(piloto);
    }
}
