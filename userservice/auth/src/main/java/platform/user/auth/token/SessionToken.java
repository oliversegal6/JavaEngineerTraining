package platform.user.auth.token;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * Created by admin on 2017/12/16.
 */
@Document
public class SessionToken
{
    @Id
    private UUID value;
    private String userId;
    private Long sessionLenth;

    public SessionToken()
    {

    }

    public SessionToken(String userId, Long sessionLenth)
    {
        this.value = UUID.randomUUID();
        this.userId = userId;
        this.sessionLenth = sessionLenth;
    }

    public String getValue()
    {
        return value.toString();
    }

    public String getUserId()
    {
        return userId;
    }
}
