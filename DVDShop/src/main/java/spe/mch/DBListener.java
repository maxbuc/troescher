package spe.mch;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent sce){
        ConnectionPool dbPool = ConnectionPool.createConnectionPool();
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("dbPool", dbPool);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){}
    
}
