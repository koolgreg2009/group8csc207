package entity.user;

import java.util.List;

public interface User {
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
    String getName();
    void setName(String name);
    String getEmail();
    void setEmail(String email);
    String getPhone();
    void setPhone(String num);
    void addNotif(String notif);
}
