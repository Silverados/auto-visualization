package xyz.wywag.cars.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xyz.wywag.cars.util.LogUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author weiyuwang
 * @since 2019/2/28 19:46
 */
@Aspect
@Component
public class LogAspect {
    /**
     * 申明一个切点 里面是 execution表达式
     */
    @Pointcut("execution(public * xyz.wywag.cars.controller.CarSalesController.*(..))")
    private void controllerAspect(){}


    /**
     * 请求method前打印内容
     */
    @Before(value = "controllerAspect()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //打印请求内容
        LogUtil.info("===============请求内容===============");
        LogUtil.info("请求地址:"+request.getRequestURL().toString());
        LogUtil.info("请求方式:"+request.getMethod());
        LogUtil.info("请求类方法:"+joinPoint.getSignature());
        LogUtil.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
        LogUtil.info("===============请求内容===============");
    }


    /**
     * 在方法执行完结后打印返回内容
     */
//    @AfterReturning(returning = "str",pointcut = "controllerAspect()")
    public void methodAfterReturning(String str){
       LogUtil.info("--------------返回内容----------------");
       LogUtil.info("Response内容:" + str);
       LogUtil.info("--------------返回内容----------------");
    }

}
