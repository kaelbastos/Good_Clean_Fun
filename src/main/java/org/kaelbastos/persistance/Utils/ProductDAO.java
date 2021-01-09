package org.kaelbastos.persistance.Utils;

import org.kaelbastos.Domain.entities.Product.Kit;
import org.kaelbastos.Domain.entities.Product.Product;


import java.util.ArrayList;
import java.util.Optional;

public abstract class ProductDAO implements DAO<Integer, Product> {
        public abstract Optional<ArrayList<Kit>> getKitsFromProducts();
}
