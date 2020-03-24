// 스프링 IoC 컨테이너를 설정하는 클래스
package com.eomcs.spring.ioc.ex13.f;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// @Configuration // 이 클래스가 설정 클래스임을 선언한다. Exam에 설정해줘서 삭제해도 된다.
@ComponentScan("com.eomcs.spring.ioc.ex13.f")
@EnableAspectJAutoProxy
public class AppConfig {
}
