package io.indorse.test.authentication.services;

import io.indorse.test.authentication.dao.dto.User;

public interface EmailService {

    public void sendSimpleEmail(User user);
}
