package ecom.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecom.DAO.User.UserDAO;
import ecom.common.UserType;
import ecom.model.User;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entered Controller");
		
		HttpSession session = request.getSession();
		
		String servletPath = request.getServletPath();  
		
		if (servletPath.equals("/SellerMainPanel")) {                     //  Seller Entry
			
				System.out.println("Entered SellerMainPanel");
				
				/********* Set Request ************/
				
				String userId   = request.getParameter("userId").trim();    
				String password = request.getParameter("password").trim();   
				
				/********* Database Check ***********/
				
				UserDAO userDAO = new UserDAO();
				User user       = userDAO.getUser(userId, password);				
				
				/********* Next Page ****************/				
				
				if (user != null) {					
					
					/********* Set Session **************/
		 			
					session.setAttribute("sellerId", user.getUserInfo().getId());
					session.setAttribute("user", user);
					
					request.getRequestDispatcher("jsp_Seller/SellerMainPanel.jsp").forward(request, response);
					
				} else {
					
					response.sendRedirect("SellerLogin");
				}
				
				
		}
		else if (servletPath.equals("/BuyerMainPanel")) {            //  Customer View    //  I think no use, but not sure
			
				System.out.println("Entered BuyerMainPanel");			
				
				/*****************************************
				 			* Next Page *
				 *****************************************/
				request.getRequestDispatcher("jsp_Buyer/BuyerMainPanel.jsp").forward(request, response);
		}
		else if (servletPath.equals("/CustomerLogin")) {                  //  Buyer Entry
			
				System.out.println("Entered CustomerLogin");
				
				/*********** Get Request ************/
				
				String userId   = request.getParameter("userId").trim();    
				String password = request.getParameter("password").trim(); 			
				
				/********* Database Check ***********/
				
				UserDAO userDAO = new UserDAO();
				User user       = userDAO.getUser(userId, password);
				
				
				/********** Next Page **************/
				
				if (user != null) {
					
					/******* Set Session **********/				
					session.setAttribute("user", user);
					
					/************** Next Page Selection *****************/				
				
					response.sendRedirect("BuyerMainPanel");
				}
				else {
					
					request.getRequestDispatcher("Login.html").forward(request, response);
				}
			
		}
		else if (servletPath.equals("/SellerLoginPage")) {                  //  Buyer Entry
			
				System.out.println("Entered SellerLoginPage");
				
				/********** Next Page **************/
				
				request.getRequestDispatcher("jsp_Seller/SellerLoginPage.jsp").forward(request, response);
				
		} //SellerLoginPage
		
		else if (servletPath.equals("/InitialDashBoard")) {                  //  Buyer Entry
			
			System.out.println("Entered InitialDashBoard");
			
			/********** Next Page **************/
			
			request.getRequestDispatcher("jsp_Seller/Initial.jsp").forward(request, response);
		}
		
		else if (servletPath.equals("/Administration")) {                  //  Admin, Franchise and Distributor  Entry
			
			System.out.println("Entered Administration");
			
			/************* Get Request *******************/
			
			String userId   = request.getParameter("userId").trim();    
			String password = request.getParameter("password").trim();   
			
			/********* Database Check ***********/
			
			UserDAO userDAO = new UserDAO();
			User user       = userDAO.getUser(userId, password);
			
			/************* Set Session *******************/
			
			session.setAttribute("user", user);
			
			/********** Set Request ***************/
			
			request.setAttribute("company", user.getUserInfo().getCompany());
			request.setAttribute("fName", user.getPerson().getFirstName());
			request.setAttribute("lName", user.getPerson().getLastName());
			
			/********** Next Page **************/
			
			boolean userExist         = user != null;
			boolean userIsAdmin       = UserType.ADMIN       == user.getUserInfo().getUserType();
			boolean userIsFranchise   = UserType.FRANCHISE   == user.getUserInfo().getUserType();
			boolean userIsDistributor = UserType.DISTRIBUTOR == user.getUserInfo().getUserType();

			if (userExist && userIsAdmin)
				
				request.getRequestDispatcher("jsp_Administration/AdminPanel.jsp").forward(request, response);
			
			else if (userExist && userIsFranchise)
				
				request.getRequestDispatcher("jsp_Administration/FranchisePanel.jsp").forward(request, response);
			
			else if (userExist && userIsDistributor)
				
				request.getRequestDispatcher("jsp_Administration/DistributorPanel.jsp").forward(request, response);
		}
		
		
		else if (servletPath.equals("/SellerRegistrationPage")) {                 
			
			System.out.println("Entered SellerRegistrationPage");			
			
			/************** Next Page *******************/
			request.getRequestDispatcher("jsp_Seller/SellerRegistration.jsp").forward(request, response);
			
		} //SellerRegistrationPage
		
		else if (servletPath.equals("/RegisterSeller")) {                 
			
			System.out.println("Entered RegisterSeller");			
			
			/************** Ajax - Next Page *******************/
			
			
		} //SellerRegistrationPage
		
		
		else if (servletPath.equals("/CustomerRegistrationPage")) {                 
			
			System.out.println("Entered CustomerRegistrationPage");			
			
			/************** Next Page *******************/
			request.getRequestDispatcher("jsp_Buyer/CustomerRegistration.jsp").forward(request, response);
			
		} //CustomerRegistrationPage
		
		else if (servletPath.equals("/RegisterCustomer")) {                 
			
			System.out.println("Entered RegisterCustomer");			
			
			/************** Next Page *******************/
			request.getRequestDispatcher("jsp_Buyer/BuyerMainPanel.jsp").forward(request, response);
			
			
		} //RegisterCustomer
		
	}
}
