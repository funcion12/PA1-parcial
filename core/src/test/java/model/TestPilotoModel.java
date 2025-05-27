package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class TestPilotoModel {

    @Test
    public void crearPiloto(){
        Piloto elPiloto = Piloto.crearPiloto(UUID.randomUUID(),"Franco colapinto","12345678" , LocalDate.of(2003,12,16));
        Assertions.assertNotNull(elPiloto);
    }

    @Test
    public void crearPilotoSinNombre(){
        Piloto elPiloto = Piloto.crearPiloto(UUID.randomUUID(),"","12345678" , LocalDate.of(2003,12,16));
        Assertions.assertNotNull(elPiloto);
    }

    @Test
    public void crearPilotoSinDocumento(){
        Piloto elPiloto = Piloto.crearPiloto(UUID.randomUUID(),"Franco colapinto","", LocalDate.of(2003,12,16));
        Assertions.assertNotNull(elPiloto);
    }
    
}
