package com.nexura.agendaSegurosBackend.Address;

import com.nexura.agendaSegurosBackend.Client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "direcciones")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;

    private String localidad;

    private String provincia;

    @OneToOne(mappedBy = "address")
    private ClientEntity client;

}
