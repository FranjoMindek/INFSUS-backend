package hr.fer.zpr.infsus.backend.controller;

import hr.fer.zpr.infsus.backend.model.Client;
import hr.fer.zpr.infsus.backend.model.ClientUpdate;
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

    @GetMapping("/clients/")
    public Client getClientByNationalId(@RequestParam String clientNationalId) {
        return this.clientService.getClientByNationalId(clientNationalId);
    }

    @PostMapping("/clients")
    public Long insertClient(@RequestBody Client client) {
        return this.clientService.insertClient(client);
    }

    @PutMapping("/clients/{clientId}")
    public boolean updateClient(@PathVariable Long clientId,
                                @RequestBody ClientUpdate clientUpdate) {
        return this.clientService.updateClient(clientUpdate);
    }

    @DeleteMapping("/clients/{clientId}")
    public boolean deleteClient(@PathVariable Long clientId) {
        return this.clientService.deleteClient(clientId);
    }
}
