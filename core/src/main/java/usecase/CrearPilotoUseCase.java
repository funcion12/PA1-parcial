package usecase;

import exception.ExceptionPilotoExiste;
import input.ICrearPilotoInput;
import model.Piloto;
import output.ICrearPilotoOutput;

public class CrearPilotoUseCase implements ICrearPilotoInput {

    private final ICrearPilotoOutput crearPilotoOutput;

    public CrearPilotoUseCase(ICrearPilotoOutput crearPilotoOutput) {
        this.crearPilotoOutput = crearPilotoOutput;
    }

    @Override
    public boolean crearPiloto(Piloto piloto) throws ExceptionPilotoExiste {
        if(piloto == null) return false;

        if(piloto.getNombre().isEmpty() || piloto.getDocumento().isEmpty() || piloto.getFecha_Nacimiento()==null || piloto.getId()==null || piloto.getNombre()==null) return false;

        if(crearPilotoOutput.existe(piloto.getDocumento())) throw new ExceptionPilotoExiste("El piloto ya existe con ese documento");

        return crearPilotoOutput.guardarPiloto(piloto);
    }

}
