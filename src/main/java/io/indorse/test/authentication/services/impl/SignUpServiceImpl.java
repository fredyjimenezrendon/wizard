package io.indorse.test.authentication.services.impl;

import io.indorse.test.authentication.dao.GenericDao;
import io.indorse.test.authentication.dao.dto.Rol;
import io.indorse.test.authentication.dao.dto.User;
import io.indorse.test.authentication.dao.dto.UserRol;
import io.indorse.test.authentication.data.UserData;
import io.indorse.test.authentication.services.EmailService;
import io.indorse.test.authentication.services.SignUpService;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    public static final String PLEASE_CHECK_YOUR_EMAIL = "Please check your email";
    public static final String YOUR_EMAIL_ALREADY_EXISTS_IN_OUR_DATABASE = "Your email already exists in our database";

    @Autowired
    private GenericDao<User> genericUserDao;

    @Autowired

    private GenericDao<UserRol> genericUserRolDao;

    @Autowired
    private EmailService emailService;

    @Override
    public String saveUser(UserData userData) {
        String result;
        if(isNewEmail(userData.getMail())){
            User user = new User();
            user.setName(userData.getName());
            user.setLastName(userData.getLastName());
            user.setEmail(userData.getMail());
            user.setPassword(userData.getPassword());
            user.setToken(UUID.randomUUID().toString());
            genericUserDao.save(user);
            Rol rol = new Rol();
            rol.setId(1);
            UserRol userRol = new UserRol();
            userRol.setUser(user);
            userRol.setRol(rol);
            genericUserRolDao.save(userRol);

            sendActivationEmail(user);

            result = PLEASE_CHECK_YOUR_EMAIL;
        } else {
            result = YOUR_EMAIL_ALREADY_EXISTS_IN_OUR_DATABASE;
        }
        return result;
    }

    @Override
    public void activateUser(String token) {
        Criterion criterion = Restrictions.eq("token", token);
        List<Criterion> criterions = new ArrayList<>();
        criterions.add(criterion);
        User user = genericUserDao.findBy(User.class, criterions).get(0);
        user.setEnabled(true);
        genericUserDao.update(user);
    }

    @Override
    public void sendActivationEmail(User userData) {
        emailService.sendSimpleEmail(userData);
    }

    @Override
    public boolean isNewEmail(String email) {
        Criterion criterion = Restrictions.eq("email", email);
        List<Criterion> criterions = new ArrayList<>();
        criterions.add(criterion);
        return genericUserDao.findBy(User.class, criterions).size() > 0 ? false : true;
    }
}
