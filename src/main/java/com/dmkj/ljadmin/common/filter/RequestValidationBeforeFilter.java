package com.dmkj.ljadmin.common.filter;

import java.io.IOException;

import org.springframework.web.filter.GenericFilterBean;

import com.dmkj.ljadmin.common.ResponseResult;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class RequestValidationBeforeFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        // if (request.getParameter("token") != null) {
        // response.getWriter().write("token: " + request.getParameter("token"));
        // return;
        // }

        // filterChain.doFilter(request, response);

        // response.getWriter().write(ResponseResult.success("token is
        // null").toString());

        filterChain.doFilter(request, response);
    }

}
