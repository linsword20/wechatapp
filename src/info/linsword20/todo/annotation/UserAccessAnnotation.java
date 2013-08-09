package info.linsword20.todo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import info.linsword20.todo.myenum.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UserAccessAnnotation
{
	ISLOGIN isLogin();
	//ROLE authority() default ROLE.USER;
}
