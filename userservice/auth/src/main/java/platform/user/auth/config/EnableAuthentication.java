package platform.user.auth.config;

import org.springframework.context.annotation.Import;

/**
 * Created by admin on 2017/12/12.
 */
@Import({AuthConfigContext.class})
public @interface EnableAuthentication
{
}
