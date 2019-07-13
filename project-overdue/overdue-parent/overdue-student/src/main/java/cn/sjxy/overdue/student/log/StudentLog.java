package cn.sjxy.overdue.student.log;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StudentLog {
    /**
     * 切入点所在模块
     */
    String module() default "";

    /**
     * 功能
     */
    String action() default "";

}
