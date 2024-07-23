package com.alexandersaul.PointOfSale.repository;

import com.alexandersaul.PointOfSale.entities.UserSec;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserSec,Long> {

    Optional<UserSec> findUserSecByUserName (String userName);

}
