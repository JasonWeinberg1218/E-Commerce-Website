package weinberg.jason.jasonsbookstore;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;

import weinberg.jason.jasonsbookstore.bean.*;

/**
 * Servlet implementation class OrderDetails
 */
@WebServlet("/orderDetails")
public class OrderDetails extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Account account;
	
	@Autowired
	private Result result;
	
    /**
     * @see AbstractServlet#AbstractServlet()
     */
    public OrderDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			int orderId = Integer.parseInt(request.getParameter("id"));
			result.setOrder(account.findOrder(orderId));
		}
		
		request.getRequestDispatcher("/WEB-INF/order-details.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
