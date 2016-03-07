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
		
		if (servletPath.equals("/SellerMainPanel")) {                     //  Seller Entry        //4-3-16
			
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
					
					response.sendRedirect("SellerLoginPage");   
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
			
			/*************** Get Request ***************/		
			String UserId         = request.getParameter("user_id")   .trim();
			String Password       = request.getParameter("password")  .trim();
			String First_Name     = request.getParameter("first_name").trim();
			String Last_Name      = request.getParameter("last_name") .trim();
			String Gender         = request.getParameter("sex")       .trim();
			String Company        = request.getParameter("company")   .trim();
			String Mobile_Number1 = request.getParameter("mobile1")   .trim();
			String Mobile_Number2 = request.getParameter("mobile2")   .trim();
			String Email1         = request.getParameter("email1")    .trim();
			String Email2         = request.getParameter("email2")    .trim();
			String Landphone1     = request.getParameter("landphone1").trim();
			String Landphone2     = request.getParameter("landphone2").trim();
			String Fax1           = request.getParameter("fax1")      .trim();
			String Fax2           = request.getParameter("fax2")      .trim();
			String Address_Line1  = request.getParameter("address1")  .trim();
			String Address_Line2  = request.getParameter("address2")  .trim();
			String City           = request.getParameter("city")      .trim();
			String State          = request.getParameter("state1")    .trim();
			String Pin            = request.getParameter("pin")       .trim();
			String Country        = request.getParameter("country1")  .trim();
			String Pancard        = request.getParameter("pancard")   .trim();
			String VoterId        = request.getParameter("voterId")   .trim();

			String First_Name2    = "";
			String Last_Name2     = "";
			String Company2       = "";
			String Mobile_Number3 = "";
			String Address_Line3  = "";
			String Address_Line4  = "";
			String City2          = "";
			String Pin2           = "";
			String State2         = "";
			String Country2       = "";
			String Email3         = "";
			
			if(request.getParameter("checkbox")!=null) {			   
				
			   First_Name2    = request.getParameter("first_name2").trim();
			   Last_Name2     = request.getParameter("last_name2") .trim();
			   Company2       = request.getParameter("company2")   .trim();
			   Mobile_Number3 = request.getParameter("mobile3")    .trim();
			   Address_Line3  = request.getParameter("address3")   .trim();
			   Address_Line4  = request.getParameter("address4")   .trim();
			   City2          = request.getParameter("city2")      .trim();
			   Pin2           = request.getParameter("pin2")       .trim();
			   State2         = request.getParameter("state2")     .trim();
			   Country2       = request.getParameter("country2")   .trim();
			   Email3         = request.getParameter("email3")     .trim();

			   
			   
			}
			
			
			
			
			
			
			
			
			
			
			
			
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
