package financas.user.repository;

import financas.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoitory extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);
}
