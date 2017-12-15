package platform.user.service;

import org.apache.cxf.transport.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.user.api.UserServiceInterface;
import platform.user.auth.token.SessionToken;
import platform.user.auth.token.TokenGenerator;
import platform.user.model.LoginRequest;
import platform.user.model.LoginResponse;
import platform.user.model.User;
import platform.user.model.UserRepository;

import java.util.Collection;

@Service
public class UserService implements UserServiceInterface
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    public void createUser(User user)
    {
        userRepository.save(user);
    }

    public Collection<User> getUsers()
    {
        return userRepository.findAll();
    }

    public LoginResponse login(LoginRequest loginRequest)
    {
        User user = authUser(loginRequest.getUsername(), loginRequest.getPassword());
        LoginResponse loginResponse = new LoginResponse();
        if(user != null)
        {
            SessionToken sessionToken = tokenGenerator.createToken(user.getUsername());
            loginResponse.setToken(sessionToken.getValue());
            loginResponse.setUsername(user.getUsername());
        }
        return loginResponse;
    }

    private User authUser(String username, String password)
    {
        User user = null;
        User dbUser = userRepository.getByUsername(username);
        if(dbUser.getPassword().equals(password))
        {
            user = dbUser;
        }
        return user;
    }
}
