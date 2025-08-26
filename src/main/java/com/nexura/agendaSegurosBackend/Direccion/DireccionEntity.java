package com.nexura.agendaSegurosBackend.Direccion;

import com.nexura.agendaSegurosBackend.Cliente.ClienteEntity;
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
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;

    private String numero;

    private String localidad;

    private String provincia;

    @OneToOne(mappedBy = "direccion")
    private ClienteEntity cliente;

}
