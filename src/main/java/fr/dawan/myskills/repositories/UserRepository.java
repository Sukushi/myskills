package fr.dawan.myskills.repositories;

import fr.dawan.myskills.entities.Authority;
import fr.dawan.myskills.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmailAndAuthTokenAndEnabled(String email, String token, boolean enabled);
	Optional<User> findByEmail(String email);
	Optional<User> findByAuthToken(String token);
	@Query("SELECT u FROM User u JOIN u.authorities a WHERE a.authority = :authority")
	Page<User> findAllByAuthority(String authority, Pageable page);
}
