package hr.fer.zpr.infsus.backend.service;

import hr.fer.zpr.infsus.backend.model.Client;
import hr.fer.zpr.infsus.backend.model.ClientUpdate;
import hr.fer.zpr.infsus.backend.model.OvernightStayInsert;
import hr.fer.zpr.infsus.backend.model.ReservationInsert;
import hr.fer.zpr.infsus.backend.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients() { return this.clientRepository.getClients(); }
    public Client getClientById(Long clientId) {
        return this.clientRepository.getClientById(clientId);
    }

    public Client getClientByNationalId(String clientNationalId) {
        return this.clientRepository.getClientByNationalId(clientNationalId);
    }

    public Long insertClientIfNew(ReservationInsert reservationInsert) {
        Client client = this.clientRepository.getClientByNationalId(reservationInsert.getClientNationalId());
        if (client == null) {
            return this.clientRepository.insertClient(
                    reservationInsert.getClientNationalId(), reservationInsert.getClientPhoneNumber(),
                    reservationInsert.getClientFirstName(), reservationInsert.getClientLastName());
        } else {
            return client.getClientId();
        }
    }

    public Long insertClientIfNew(OvernightStayInsert overnightStayInsert) {
        Client client = this.clientRepository.getClientByNationalId(overnightStayInsert.getClientNationalId());
        if (client == null) {
            return this.clientRepository.insertClient(
                    overnightStayInsert.getClientNationalId(), overnightStayInsert.getClientPhoneNumber(),
                    overnightStayInsert.getClientFirstName(), overnightStayInsert.getClientLastName());
        } else {
            return client.getClientId();
        }
    }

    public Long insertClient(Client client) {
        return this.clientRepository.insertClient(
                client.getClientNationalId(), client.getClientPhoneNumber(), client.getClientFirstName(), client.getClientLastName()
        );
    }

    public boolean updateClient(ClientUpdate clientUpdate) {
        return this.clientRepository.updateClient(clientUpdate);
    }

    public boolean deleteClient(Long clientId) {
        return this.clientRepository.deleteClient(clientId);
    }
}
