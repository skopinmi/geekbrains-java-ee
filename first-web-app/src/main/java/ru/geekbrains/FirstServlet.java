package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

// работает deploy через github
//http://80.78.247.129:8080/first-web-app/

public class FirstServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(FirstServlet.class);
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("Servlet initialized.");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return  this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request!");
        servletResponse.getWriter().println("<h1>Hello from Servlet !</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
