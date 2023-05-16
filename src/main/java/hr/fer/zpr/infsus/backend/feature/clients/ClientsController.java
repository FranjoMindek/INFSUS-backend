package hr.fer.zpr.infsus.backend.feature.clients;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientDTO;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsertDTO;
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

    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return this.clientsService.getClientById(id);
    }

    @GetMapping("/clients/")
    public ClientDTO getClientByNationalId(@RequestParam String clientNationalId) {
        return this.clientsService.getClientByNationalId(clientNationalId);
    }

    @PostMapping("/clients")
    public Long insertClient(@RequestBody ClientInsertDTO client) {
        return this.clientsService.insertClient(client);
    }

    @PutMapping("/clients/{id}")
    public boolean updateClient(@PathVariable Long id,
                                @RequestBody ClientDTO clientDTO) {
        return this.clientsService.updateClient(clientDTO);
    }

    @DeleteMapping("/clients/{id}")
    public boolean deleteClient(@PathVariable Long id) {
        return this.clientsService.deleteClient(id);
    }
}
