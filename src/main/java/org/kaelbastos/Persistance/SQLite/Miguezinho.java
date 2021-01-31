package org.kaelbastos.Persistance.SQLite;

import org.kaelbastos.Domain.Entities.Client.Client;
import org.kaelbastos.Domain.Entities.Client.ResidenceType;
import org.kaelbastos.Domain.Entities.utils.Address;
import org.kaelbastos.Domain.Entities.utils.Person;
import org.kaelbastos.Persistance.PersistenceFacade;

import java.sql.SQLException;

public class Miguezinho {
    public static void main(String[] args) throws SQLException {
        PersistenceFacade persistenceFacade = PersistenceFacade.getInstance();
        Client client = new Client("00000000006",
                "batata",
                "00000000000",
                "client@client.com",
                new Address("rua dos bobos",
                        "neighborhood",
                        "city",
                        "state",
                        "0",
                        "2",
                        null),
                ResidenceType.House);
    }
}
