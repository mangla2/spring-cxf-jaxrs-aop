package aspect;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
@Aspect
public class FilterAspect {

    public static final String ACCESS_TOKEN_HEADER = "accessToken";

    @Pointcut("@annotation(annotations.Authorize)")
    public void invokeAnnotation() {}

    @Before("invokeAnnotation()")
    public void doBefore(final JoinPoint joinPoint) throws IOException {
         ServletRequestAttributes t = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
         HttpServletRequest req = t.getRequest();

        final String accessToken = req.getHeader(ACCESS_TOKEN_HEADER);
        if (accessToken == null) {
            System.out.println("Access Denied !!");
            return;
        }
    }

}
