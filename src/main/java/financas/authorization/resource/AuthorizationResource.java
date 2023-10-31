package financas.authorization.resource;

import financas.authorization.dto.AuthenticationDTO;
import financas.authorization.dto.RegisterDTO;
import financas.user.model.User;
import financas.user.repository.UserRepoitory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthorizationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepoitory userRepoitory;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody  @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.userRepoitory.findByLogin(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), data.password(), data.role());

        this.userRepoitory.save(newUser);
        return ResponseEntity.ok().build();
    }
}
