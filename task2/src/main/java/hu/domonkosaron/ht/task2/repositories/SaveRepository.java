package hu.domonkosaron.ht.task2.repositories;

import hu.domonkosaron.ht.task2.models.RegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaveRepository extends JpaRepository<RegistrationForm, Long> {
    Optional<RegistrationForm> findByEmailAddress(String email);
}
