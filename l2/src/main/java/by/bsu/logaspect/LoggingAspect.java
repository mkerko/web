package by.bsu.logaspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;

/**
 * Created by Mikhail on 09.12.2017.
 */

@Aspect
public class LoggingAspect {

    private Logger log = Logger.getLogger(getClass());

    @After("execution(* by.bsu.DAO.impl.UserDAOImpl.*(..))")
    public void log(JoinPoint point) throws MalformedURLException {
        System.setProperty("log4j.configuration", String.valueOf(new File("log4j.properties")));
        log.info(point.getSignature().getDeclaringType() + " method --" + point.getSignature().getName() + "(..) called with params: " + Arrays.toString(point.getArgs()));
    }
}


