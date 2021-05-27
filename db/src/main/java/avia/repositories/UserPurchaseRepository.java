package avia.repositories;

import avia.models.UserPurchase;
import org.springframework.data.repository.CrudRepository;

public interface UserPurchaseRepository  extends CrudRepository<UserPurchase, Integer> {
}
