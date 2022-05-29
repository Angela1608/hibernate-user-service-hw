package mate.academy.service.impl;

import java.util.Optional;
import mate.academy.dao.UserService;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.User;
import mate.academy.util.HashUtil;

@Service
public class UserServiceImpl implements mate.academy.service.UserService {
    @Inject
    private UserService userDao;

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}