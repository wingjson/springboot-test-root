package com.zja.mvc.filter.webfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应内容修改：
 * 场景：对响应内容进行修改，例如添加特定的响应头、修改响应体等。
 * @author: zhengja
 * @since: 2024/03/11 16:33
 */
// @WebFilter(urlPatterns = "/*")
public class ResponseModificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 对响应进行修改，例如添加自定义的响应头、修改响应体等
        modifyResponse(httpResponse);

        chain.doFilter(request, response);
    }

    // 其他方法：init() 和 destroy()

    private void modifyResponse(HttpServletResponse response) {
        response.setHeader("Custom-Header", "Custom Value");

        // 修改响应体的内容
        // ...
    }
}