package com.nexura.agendaSegurosBackend.Client.Exceptions;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound(String message) {
        super(message);
    }
}
