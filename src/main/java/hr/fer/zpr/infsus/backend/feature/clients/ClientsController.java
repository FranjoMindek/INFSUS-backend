package hr.fer.zpr.infsus.backend.feature.clients;

import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientDTO;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientInsert;
import hr.fer.zpr.infsus.backend.feature.clients.dto.ClientUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ClientsController {

    private final ClientsService clientsService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO> >getClients() {
        return ResponseEntity.ok(this.clientsService.getClients());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        ClientDTO dto = this.clientsService.getClientById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/clients/")
    public ResponseEntity<ClientDTO> getClientByNationalId(@RequestParam String clientNationalId) {
        ClientDTO dto = this.clientsService.getClientByNationalId(clientNationalId);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("/clients")
    public ResponseEntity<?> insertClient(@RequestBody ClientInsert clientInsert) {
        Long id = this.clientsService.insertClient(clientInsert);
        return ResponseEntity.created(URI.create("/api/clients/" + id)).build();
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientUpdateDTO clientUpdateDTO) {
        if (this.clientsService.updateClient(clientUpdateDTO)) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        if (this.clientsService.deleteClient(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
