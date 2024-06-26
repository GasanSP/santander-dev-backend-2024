package me.dio.santander_dev_backend_2024.repository;

import me.dio.santander_dev_backend_2024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByAccountNumber(String accountNumber);

}
