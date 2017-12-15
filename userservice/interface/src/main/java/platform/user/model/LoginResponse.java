package platform.user.model;

/**
 * Created by admin on 2017/12/16.
 */
public class LoginResponse
{
    private String token;
    private String username;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
