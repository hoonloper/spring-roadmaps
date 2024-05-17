package com.spring_02.basic.response;

import com.spring_02.basic.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HelloServlet {
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Content-Type: text/html;charset=utf-8
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");

    PrintWriter writer = response.getWriter();

    writer.println("<html>");
    writer.println("<body>");
    writer.println("  <div>안녕?</div>");
    writer.println("</body>");
    writer.println("</html>");
  }
}
