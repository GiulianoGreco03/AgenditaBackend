package com.nexura.agendaSegurosBackend.Vehicle;

import com.nexura.agendaSegurosBackend.Client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private VehicleType vehicleType;

    private String marca;

    private String modelo;

    private String dominio;

    private String numChasis;

    private String numMotor;

    private String Registro;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientEntity cliente;
}
