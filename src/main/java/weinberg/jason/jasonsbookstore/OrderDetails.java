package weinberg.jason.jasonsbookstore;

import java.io.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import weinberg.jason.jasonsbookstore.bean.*;
import weinberg.jason.jasonsbookstore.model.*;

/**
 * Servlet implementation class OrderDetails
 */
@WebServlet("/orderDetails")
public class OrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Account account;
	
    /**
     * @see HttpServlet#HttpServlet()
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
			
			Order order = account.getOrder(orderId);
			
			request.setAttribute("order", order);
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