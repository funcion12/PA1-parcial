package input;

import exception.ExceptionPilotoExiste;
import model.Piloto;

public interface ICrearPilotoInput {
    boolean crearPiloto(Piloto piloto) throws ExceptionPilotoExiste;
}
