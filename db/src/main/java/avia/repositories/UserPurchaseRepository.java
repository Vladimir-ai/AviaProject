package avia.repositories;

import avia.models.PurchaseModel;
import org.springframework.data.repository.CrudRepository;

public interface UserPurchaseRepository  extends CrudRepository<PurchaseModel, Integer> {
}
