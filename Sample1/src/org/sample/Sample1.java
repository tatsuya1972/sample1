package org.sample;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sample1
 */
@WebServlet("/Sample1")
public class Sample1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // get environment
        InetAddress ia = InetAddress.getLocalHost();
        String IpAddr = ia.getHostAddress();
        String HostName = ia.getHostName();
        request.setAttribute("IPaddr", IpAddr);
        request.setAttribute("Hostname", HostName);

        // get http parameter
        String param1 = request.getParameter("param1");

        // get session object
        HttpSession session = request.getSession();
        SessionObject so = (SessionObject)session.getAttribute("param1");
        if (so == null) {
            so = new SessionObject();
            session.setAttribute("param1", so);
        }

        // set entity bean
        if ( param1 != null ) {
            so.setParam1(param1);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ReplySample1.jsp");
        requestDispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
