package platform.user.auth.token;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/12/16.
 */
@Component
public class TokenGenerator
{
    private Long sessionLength;

    public SessionToken createToken(String userId)
    {
        return new SessionToken(userId, sessionLength);
    }
}
