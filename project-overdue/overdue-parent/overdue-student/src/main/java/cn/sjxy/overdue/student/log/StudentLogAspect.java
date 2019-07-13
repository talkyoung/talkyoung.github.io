package cn.sjxy.overdue.student.log;

import cn.sjxy.overdue.dao.LogdetailMapper;
import cn.sjxy.overdue.pojo.Logdetail;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component("studentLogAspect")
public class StudentLogAspect {
    @Autowired
    LogdetailMapper logdetailMapper;

    private static final Logger studentLogAspect = LoggerFactory.getLogger(StudentLogAspect.class);

    // 配置织入点
    @Pointcut("@annotation(cn.sjxy.overdue.student.log.StudentLog)")
    public void logPointCut() {
    }

    @AfterReturning("logPointCut()")
    public void afterReturning(JoinPoint joinPoint) {
        handleLog(joinPoint, null);
    }

    /**
     * 拦截异常操作，有异常时执行
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e);
    }

    private void handleLog(JoinPoint joinPoint, Exception e) {
        try {
            // 获得注解
            StudentLog annotationLog = getAnnotationLog(joinPoint);
            if (annotationLog == null) {
                return;
            }
            // 获得方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            String action = annotationLog.action();
            String module = annotationLog.module();
            //打印日志，如有需要还可以存入数据库
            studentLogAspect.info(">>>>>>>>>>>>>模块名称：{}", module);
            studentLogAspect.info(">>>>>>>>>>>>>操作名称：{}", action);
            studentLogAspect.info(">>>>>>>>>>>>>类名：{}", className);
            studentLogAspect.info(">>>>>>>>>>>>>方法名：{}", methodName);
            //将数据保存到数据库中
            Logdetail logdetail = new Logdetail();
            logdetail.setLogRole("Student");
            logdetail.setLogAction(action);
            logdetail.setLogModule(module);
            logdetail.setLogName(SecurityContextHolder.getContext()
                    .getAuthentication().getName());
            logdetail.setLogTime(new Date());
            logdetailMapper.insert(logdetail);
        } catch (Exception exp) {
            // 记录本地异常日志
            studentLogAspect.error("==前置通知异常==");
            studentLogAspect.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private static StudentLog getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(StudentLog.class);
        }
        return null;
    }

}
