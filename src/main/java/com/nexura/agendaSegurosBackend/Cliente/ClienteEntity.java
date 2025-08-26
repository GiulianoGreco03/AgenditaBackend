package com.nexura.agendaSegurosBackend.Cliente;

import com.nexura.agendaSegurosBackend.Direccion.DireccionEntity;
import com.nexura.agendaSegurosBackend.Vehiculo.VehiculoEntity;
import com.nexura.agendaSegurosBackend.Usuario.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true)
    private String dni;

    @Column
    private String telefono;

    @Column
    private String email;

    @Column
    private LocalDate fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", unique = true)
    private DireccionEntity direccion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<VehiculoEntity> vehiculos;

}
