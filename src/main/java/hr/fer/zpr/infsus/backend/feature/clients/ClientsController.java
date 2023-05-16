package hr.fer.zpr.infsus.backend.feature.clients;

import hr.fer.zpr.infsus.backend.feature.clients.data.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientsController {

    private final ClientsService clientsService;

    @GetMapping("/clients")
    public List<ClientDTO> getClients() {
        return this.clientsService.getClients();
    }

    @GetMapping("/clients/{clientId}")
    public ClientDTO getClientById(@PathVariable Long clientId) {
        return this.clientsService.getClientById(clientId);
    }

    @GetMapping("/clients/")
    public ClientDTO getClientByNationalId(@RequestParam String clientNationalId) {
        return this.clientsService.getClientByNationalId(clientNationalId);
    }

    @PostMapping("/clients")
    public Long insertClient(@RequestBody ClientDTO client) {
        return this.clientsService.insertClient(client);
    }

    @PutMapping("/clients/{clientId}")
    public boolean updateClient(@PathVariable Long clientId,
                                @RequestBody ClientDTO clientDTO) {
        return this.clientsService.updateClient(clientDTO);
    }

    @DeleteMapping("/clients/{clientId}")
    public boolean deleteClient(@PathVariable Long clientId) {
        return this.clientsService.deleteClient(clientId);
    }
}
