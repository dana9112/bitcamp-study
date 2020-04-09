package com.eomcs.lms.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.AppConfig;


// 웹어플리케이션 초기화 -> 다른 서블릿을 위해서 준비할 때 이렇게 만든다.
// loadonstartup응 사용하면 자동으로 init가 실행된다.
@WebServlet(value = "/AppInitServlet", loadOnStartup = 1) // URL을 지정해야만 나온다.
public class AppInitServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  static Logger logger = LogManager.getLogger(AppInitServlet.class);


  @Override
  public void init() throws ServletException {
    try {
      ApplicationContext iocContainer = new AnnotationConfigApplicationContext(//
          AppConfig.class);
      printBeans(iocContainer);

      ServletContext servletContext = getServletContext();
      servletContext.setAttribute("iocContainer", iocContainer);

      logger.debug("----------------------------");


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void printBeans(ApplicationContext appCtx) {
    logger.debug("Spring IoC 컨테이너에 들어있는 객체들:");
    String[] beanNames = appCtx.getBeanDefinitionNames();
    for (String beanName : beanNames) {
      logger.debug(String.format("%s =======> %s", //
          beanName, //
          appCtx.getBean(beanName).getClass().getName()));
    }
  }

}
