
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class MyFAFilter
 */
@WebFilter(filterName = "MyFAFilter", urlPatterns = {"/fa/*"}) //urlPatterns可以是資料夾
public class MyFAFilter implements Filter { //只要實作Filter就好

	private FilterConfig filterConfig = null;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Pre-Process Start");
		System.out.println("Pre-Process==>" + filterConfig.getFilterName());
		long start = System.currentTimeMillis(); //把現在時間變成一個數字
		chain.doFilter(request, response); //這裡才真正執行/FAServlet
		long end = System.currentTimeMillis();
		System.out.println("執行時間:" + (end - start) + "ms");
		System.out.println("Post-Process==>" + filterConfig.getFilterName());
		System.out.println("=====================================");

	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) { //filterConfig參數帶進這裡private FilterConfig filterConfig = null;
		this.filterConfig = filterConfig;

	}

	@Override
	public String toString() {
		if (filterConfig == null) {
			return ("FilterA()");
		}
		StringBuffer sb = new StringBuffer("FilterA(");
		sb.append(filterConfig);
		sb.append(")");
		return (sb.toString());
	}

	public void log(String msg) {
		filterConfig.getServletContext().log(msg);
	}

}
