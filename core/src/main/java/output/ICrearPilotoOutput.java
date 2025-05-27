package output;

import model.Piloto;

public interface ICrearPilotoOutput {
    Piloto crearPiloto(Piloto piloto);
    boolean guardarPiloto(Piloto piloto);
    boolean existe(String documento);}
