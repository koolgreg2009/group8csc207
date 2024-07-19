package entity.user;

import java.util.List;

public interface User {
	long getUserId();
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
    List<String> notification(List<String> notif);
}
