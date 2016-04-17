package gr.javapapo.sample.cdi;

/**
 * Created by <a href="mailto:javapapo@mac.com">javapapo</a> on 24/09/15.
 */
import javax.enterprise.util.Nonbinding;
import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CheckRequest {
    @Nonbinding String role() default "ADMIN";
}

