package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Piloto {
    private UUID id;
    private String nombre;
    private String documento;
    private LocalDate fecha_Nacimiento;

    private Piloto(UUID id, String nombre, String documento, LocalDate fecha_Nacimiento){
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public static Piloto crearPiloto(UUID id, String nombre, String documento, LocalDate fecha_Nacimiento){
        if(Period.between(fecha_Nacimiento,LocalDate.now()).getYears()<18){
            throw new IllegalArgumentException("El piloto no puede ser menor de edad");
        }

        return new Piloto(id, nombre, documento, fecha_Nacimiento);
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public UUID getId() {
        return id;
    }
}
