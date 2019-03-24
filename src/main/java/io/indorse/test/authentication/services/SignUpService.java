package io.indorse.test.authentication.services;

import io.indorse.test.authentication.dao.dto.User;
import io.indorse.test.authentication.data.UserData;

public interface SignUpService {

    String saveUser(UserData userData);
    void activateUser(String token);
    void sendActivationEmail(User userData);
    boolean isNewEmail(String email);

}
