package com.nexura.agendaSegurosBackend.Client;

import com.nexura.agendaSegurosBackend.Adress.AddressDTO;

import java.time.LocalDate;

public record ClientDTO(
        String name,
        String lastName,
        String dni,
        String phone,
        String email,
        LocalDate birthDate,
        AddressDTO address,
        String userEmail
) {
}
