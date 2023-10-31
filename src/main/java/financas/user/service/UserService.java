package financas.user.service;

import financas.user.repository.UserRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepoitory userRepository;

}
