package org.kaelbastos.Persistance.DAOs;

import org.kaelbastos.Domain.Entities.Product.Kit;
import org.kaelbastos.Domain.Entities.Product.Product;
import java.util.List;
import java.util.Optional;

public abstract class ProductDAO implements DAO<Integer, Product> {
        public abstract Optional<List<Kit>> getKitsFromProducts();
}
