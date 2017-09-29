package support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class TestServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                                throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(
             "<html><body><table border=\"1\"><tbody><td>" +
                "<input id=\"userauth_username\" value type=\"text\" name=\"username\" class=\"loginbox\" placeholder=\"Username\">" +
                "<input id=\"userauth_password\" value type=\"text\" name=\"username\" class=\"loginbox\" placeholder=\"Password\">" +
                "</td></tr></table></body></html>");
    }
}