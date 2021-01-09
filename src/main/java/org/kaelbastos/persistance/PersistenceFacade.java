package org.kaelbastos.persistance;

import org.kaelbastos.persistance.DAOs.HashMap.ClientHashMapDAO;
import org.kaelbastos.persistance.DAOs.HashMap.ProductHashMapDAO;
import org.kaelbastos.persistance.Utils.CLientDAO;
import org.kaelbastos.persistance.Utils.ProductDAO;

/* in Ingrid We Trust*/
public class PersistenceFacade {
    private static PersistenceFacade instance;

    CLientDAO clientDAO = new ClientHashMapDAO();
    ProductDAO productDAO = new ProductHashMapDAO();

    private PersistenceFacade() {}

    public static PersistenceFacade getInstance(){
        if (instance == null)
            instance = new PersistenceFacade();
        return instance;
    }


}
