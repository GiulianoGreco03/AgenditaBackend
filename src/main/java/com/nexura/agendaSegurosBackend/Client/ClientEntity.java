package com.nexura.agendaSegurosBackend.Client;

import com.nexura.agendaSegurosBackend.Address.AddressEntity;
import com.nexura.agendaSegurosBackend.Vehicle.VehicleEntity;
import com.nexura.agendaSegurosBackend.User.UserEntity;
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
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String dni;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", unique = true)
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicles;

}
