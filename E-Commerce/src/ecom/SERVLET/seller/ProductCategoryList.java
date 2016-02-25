package ecom.SERVLET.seller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductCategoryList")
public class ProductCategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("Entered ProductCategoryList");
		
		String value = request.getParameter("value");
		
		String options = getOptionsList(value);		
		
		response.getWriter().write(options);
	}
	
	public String getOptionsList(String value) {
		
		String options = null;
		
		if (value.equals("null")) {
			
			options = "<option value=\"null\">--sub category--</option>";
					
		}
		else if (value.equals("ELECTRONICS")) {
			
			options = "<option value=\"Mobile\">Mobile</option>"
					+"<option value=\"Tablets\">Tablets</option>"
					+"<option value=\"Laptops\">Laptops</option>"
					+"<option value=\"Television\">Television</option>"
					+"<option value=\"KitchenAppliences\">Kitchen Appliences</option>"
					+"<option value=\"Cameras\">Cameras</option>"
					+"";
		}	
		else if (value.equals("MEN")) {
			
			options = "<option value=\"Footwear\">Footwear</option>"
					+"<option value=\"Clothing\">Clothing</option>"
					+"<option value=\"Watches\">Watches</option>"
					+"<option value=\"Bags\">Bags</option>"
					+"<option value=\"Belts\">Belts</option>"
					+"<option value=\"Wallets\">Wallets</option>"
					+"<option value=\"Sunglasses\">Sunglasses</option>"
					+"";
		}
		else if (value.equals("WOMEN")) {
			
			options = "<option value=\"Leggings\">Leggings</option>"
					+"<option value=\"Clothing\">Clothing</option>"
					+"<option value=\"Watches\">Watches</option>"
					+"<option value=\"Bags\">Bags</option>"
					+"<option value=\"Belts\">Belts</option>"
					+"<option value=\"Wallets\">Wallets</option>"
					+"<option value=\"Sunglasses\">Sunglasses</option>"
					+"";
		}
		
		
		return options;
	}
}
