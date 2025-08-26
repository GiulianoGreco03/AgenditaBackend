package com.nexura.agendaSegurosBackend.Cliente;

import com.nexura.agendaSegurosBackend.Usuario.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final UsuarioRepository usuarioRepository;

    public ClienteController(ClienteService clienteService, UsuarioRepository usuarioRepository) {
        this.clienteService = clienteService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<ClienteDTO> getClientes() {
        return clienteService.getClientes();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> postCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO creado = clienteService.crearCliente(clienteDTO);
        return ResponseEntity.ok().body(creado);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ClienteDTO>> getClienteByUsuarioId(@PathVariable Long id, @AuthenticationPrincipal UserDetails user) {

        if(user.getUsername().equals(usuarioRepository.findById(id).get().getUsername()))
            return ResponseEntity.ok().body(clienteService.getClientesByUsuarioID(id));
        else
            return ResponseEntity.notFound().build();
    }
}
