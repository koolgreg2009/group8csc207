package entity.User;

import java.time.LocalDateTime;

public interface UserFactory {
    User create(String username, String password, String name, String email, String phone);

    // User create(String username, String password, LocalDateTime now);

    //User create(String username, String password, LocalDateTime now);
}
