package cn.sjxy.overdue.teacher.log;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TeacherLog {
    /**
     * 切入点所在模块
     */
    String module() default "";

    /**
     * 功能
     */
    String action() default "";

}
