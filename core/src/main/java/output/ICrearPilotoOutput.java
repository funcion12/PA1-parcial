package output;

import model.Piloto;

public interface ICrearPilotoOutput {

    boolean guardarPiloto(Piloto piloto);
    boolean existe(String documento);
}
