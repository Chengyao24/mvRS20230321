

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.*;
/**
 * Servlet Filter implementation class MyJspFilter
 */

public class MyJspFilter  implements Filter {
       
	 private FilterConfig filterConfig = null;
	 
	    public void init(FilterConfig filterConfig) {
	        this.filterConfig = filterConfig;        
	    }
	    public void doFilter(ServletRequest request, ServletResponse response,  FilterChain chain)  throws IOException, ServletException 
	    {    
	        String password = ((HttpServletRequest) request).getParameter("password");  //取得欄位是password的 //name,或是在網址上打
	       
	        if (password!=null && password.equals("test") ) { //當密碼為test時,才會執行html
	            chain.doFilter(request, response);
	        } else {
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            out.println("<HTML>");
	            out.println("<HEAD>");
	            out.println("<TITLE>");
	            out.println("Incorrect Password");
	            out.println("</TITLE>");
	            out.println("</HEAD>");
	            out.println("<BODY>");
	            out.println("<H1>Incorrect Password</H1>");
	            out.println("Sorry, that password was incorrect.");
	            out.println("</BODY>");
	            out.println("</HTML>");
	        }
	    }
	    public void destroy() {
	    }

}
