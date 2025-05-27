package usecase;

import exception.ExceptionPilotoExiste;
import model.Piloto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.ICrearPilotoOutput;

import java.time.LocalDate;
import java.util.UUID;

import static model.Piloto.crearPiloto;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearPilotoUseCaseTest {
    @Mock
    ICrearPilotoOutput crearPilotoOutput;

    private UUID id = UUID.randomUUID();

    @Test
    public void crearPiloto_pilotoNoExiste_crearPiloto() throws ExceptionPilotoExiste {
        Piloto elPiloto = crearPiloto(id,"Franco colapinto","12345678" ,LocalDate.of(2003,12,16));

        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoOutput);

        when(crearPilotoOutput.existe(elPiloto.getDocumento())).thenReturn(false);
        when(crearPilotoOutput.guardarPiloto(elPiloto)).thenReturn(true);

        boolean resultado = crearPilotoUseCase.crearPiloto(elPiloto);

        Assertions.assertTrue(resultado);

    }


    @Test
    public void crearPiloto_pilotoExiste_noCrearPiloto() throws ExceptionPilotoExiste {

        Piloto elPiloto = crearPiloto(id,"Franco colapinto","12345678" ,LocalDate.of(2003,12,16));

        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoOutput);

        when(crearPilotoOutput.existe(elPiloto.getDocumento())).thenReturn(true);

        Assertions.assertThrows(ExceptionPilotoExiste.class, () -> crearPilotoUseCase.crearPiloto(elPiloto));
    }

    @Test
    public void crearPiloto_atributosObligatorios_noCrearPiloto() throws ExceptionPilotoExiste {
        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoOutput);

        Piloto pilotoSinNombre = Piloto.crearPiloto(id, "", "12345678", LocalDate.of(2000, 1, 1));
        Piloto pilotoSinDocumento = Piloto.crearPiloto(UUID.randomUUID(), "Franco Colapinto", "", LocalDate.of(2000, 1, 1));

        Assertions.assertFalse(crearPilotoUseCase.crearPiloto(pilotoSinNombre));
        Assertions.assertFalse(crearPilotoUseCase.crearPiloto(pilotoSinDocumento));

    }

    @Test
    public void crearPiloto_pilotoMenorDeEdad_noCrearPiloto() throws ExceptionPilotoExiste {



        Piloto elPiloto = crearPiloto(id, "Franco Colapinto", "12345678", LocalDate.of(2003, 12, 16));

        Assertions.assertNotNull(elPiloto);
        Assertions.assertEquals(id, elPiloto.getId());
        Assertions.assertEquals("Franco Colapinto", elPiloto.getNombre());
        Assertions.assertEquals("12345678", elPiloto.getDocumento());
        Assertions.assertEquals(LocalDate.of(2003, 12, 16), elPiloto.getFecha_Nacimiento());
    }

    @Test
    public void crearPiloto_pilotoCreado_devolverID() throws ExceptionPilotoExiste {
        Piloto elPiloto = Piloto.crearPiloto(id, "Franco Colapinto", "12345678", LocalDate.of(2003, 12, 16));

        CrearPilotoUseCase crearPilotoUseCase = new CrearPilotoUseCase(crearPilotoOutput);

        when(crearPilotoOutput.existe(elPiloto.getDocumento())).thenReturn(false);
        when(crearPilotoOutput.guardarPiloto(elPiloto)).thenReturn(true);

        boolean resultado = crearPilotoUseCase.crearPiloto(elPiloto);

        Assertions.assertTrue(resultado);
        Assertions.assertNotNull(elPiloto.getId());
        Assertions.assertInstanceOf(UUID.class, elPiloto.getId());
    }
}