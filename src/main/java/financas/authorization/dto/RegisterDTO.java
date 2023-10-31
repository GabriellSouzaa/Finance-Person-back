package financas.authorization.dto;

import financas.user.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
