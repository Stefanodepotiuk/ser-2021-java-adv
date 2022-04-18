package ua.com.owu.ser2021javaadv.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ua.com.owu.ser2021javaadv.models.entity.User;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(2)
public class CustomFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter 2");
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(servletRequest.getInputStream(), User.class);
        System.out.println(user);

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
