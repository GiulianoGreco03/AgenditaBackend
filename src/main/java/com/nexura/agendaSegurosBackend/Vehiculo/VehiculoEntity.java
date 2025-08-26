package com.nexura.agendaSegurosBackend.Vehiculo;

import com.nexura.agendaSegurosBackend.Cliente.ClienteEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "vehiculos")
public class VehiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private TipoVehiculo tipoVehiculo;

    private String marca;

    private String modelo;

    private String dominio;

    private String numChasis;

    private String numMotor;

    private String Registro;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;


    public VehiculoEntity() {
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public void setRegistro(String registro) {
        Registro = registro;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDominio() {
        return dominio;
    }

    public String getNumChasis() {
        return numChasis;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public String getRegistro() {
        return Registro;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }


    public static class Builder{
        private TipoVehiculo tipoVehiculo;
        private String marca;
        private String modelo;
        private String dominio;
        private String numChasis;
        private String numMotor;
        private String Registro;
        private ClienteEntity cliente;


        public Builder setTipoVehiculo(TipoVehiculo tipoVehiculo) {
            this.tipoVehiculo = tipoVehiculo;
            return this;
        }

        public Builder setMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public Builder setModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder setDominio(String dominio) {
            this.dominio = dominio;
            return this;
        }

        public Builder setNumChasis(String numChasis) {
            this.numChasis = numChasis;
            return this;
        }

        public Builder setNumMotor(String numMotor) {
            this.numMotor = numMotor;
            return this;
        }

        public Builder setRegistro(String registro) {
            Registro = registro;
            return this;
        }

        public Builder setCliente(ClienteEntity cliente) {
            this.cliente = cliente;
            return this;
        }



        public VehiculoEntity build(){
            VehiculoEntity vehiculo = new VehiculoEntity();
            vehiculo.setTipoVehiculo(tipoVehiculo);
            vehiculo.setMarca(marca);
            vehiculo.setModelo(modelo);
            vehiculo.setDominio(dominio);
            vehiculo.setNumChasis(numChasis);
            vehiculo.setNumMotor(numMotor);
            vehiculo.setRegistro(Registro);
            vehiculo.setCliente(cliente);

            return vehiculo;
        }
    }
}
