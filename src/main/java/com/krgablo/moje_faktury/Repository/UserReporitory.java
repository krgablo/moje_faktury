package com.krgablo.moje_faktury.Repository;

import com.krgablo.moje_faktury.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReporitory extends CrudRepository<User, Integer> {
}
