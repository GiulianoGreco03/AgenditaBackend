package com.nexura.agendaSegurosBackend.Client;

import com.nexura.agendaSegurosBackend.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientController {

    private final ClientService clienteService;
    private final UserRepository userRepository;

    public ClientController(ClientService clienteService, UserRepository userRepository) {
        this.clienteService = clienteService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<ClientDTO> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping
    public ResponseEntity<ClientDTO> postCliente(@RequestBody ClientDTO clientDTO) {
        ClientDTO creado = clienteService.crearCliente(clientDTO);
        return ResponseEntity.ok().body(creado);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ClientDTO>> getClienteByUsuarioId(@PathVariable Long id, @AuthenticationPrincipal UserDetails user) {

        if(user.getUsername().equals(userRepository.findById(id).get().getUsername()))
            return ResponseEntity.ok().body(clienteService.getClientesByUsuarioID(id));
        else
            return ResponseEntity.notFound().build();
    }
}
