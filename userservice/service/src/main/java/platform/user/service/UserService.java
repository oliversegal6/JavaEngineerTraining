package platform.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.user.api.UserServiceInterface;
import platform.user.model.User;
import platform.user.model.UserRepository;

import java.util.Collection;

@Service
public class UserService implements UserServiceInterface
{
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user)
    {
        userRepository.save(user);
    }

    public Collection<User> getUsers()
    {
        return userRepository.findAll();
    }
}
