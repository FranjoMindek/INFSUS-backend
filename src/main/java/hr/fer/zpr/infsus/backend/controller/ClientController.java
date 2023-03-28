package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.Client;
import hr.fer.zpr.infsus.backend.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getClients() {
        return this.clientService.getClients();
    }

    @GetMapping("/clients/{clientId}")
    public Client getClientById(@PathVariable Long clientId) {
        return this.clientService.getClientById(clientId);
    }

    @PutMapping("/clients/{clientId}")
    public boolean updateClient(@PathVariable Long clientId,
                                @RequestBody Client client) {
        return this.clientService.updateClient(client);
    }

    @DeleteMapping("/clients/{clientId}")
    public boolean deleteClient(@PathVariable Long clientId) {
        return this.clientService.deleteClient(clientId);
    }
}
