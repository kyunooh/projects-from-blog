package gr.javapapo.sample.cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotAllowedException;

/**
 * CDI interceptor for the {@linkplain CheckRequest} annotation
 * Created by <a href="mailto:javapapo@mac.com">javapapo</a> on 24/09/15.
 */
@Interceptor
@CheckRequest
public class CheckRequestInterceptor {

    @Inject
    HttpServletRequest request;

    @AroundInvoke
    public Object checkAccess(InvocationContext ctx) throws Exception {
        CheckRequest annotation = ctx.getMethod().getAnnotation(CheckRequest.class);
        String role = annotation.role();

        String roleToken = request.getHeader("roleToken");
        if(roleToken==null && !role.equals(roleToken)){
            throw new NotAllowedException("Not allowed if your request does not have the roleToken header " +
                    "or your role is not correct ");
        }
        return ctx.proceed();
    }
}

