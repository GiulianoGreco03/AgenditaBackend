package com.nexura.agendaSegurosBackend.Cliente;

import com.nexura.agendaSegurosBackend.Direccion.DireccionDTO;

import java.time.LocalDate;

public record ClienteDTO(
        String nombre,
        String apellido,
        String dni,
        String telefono,
        String email,
        LocalDate fechaNacimiento,
        DireccionDTO direccion,
        String emailUsuario
) {
}
