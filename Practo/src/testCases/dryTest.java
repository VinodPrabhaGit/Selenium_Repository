package testCases;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;





class book1{
	  String bk;
	  book1(String book){
		  bk = book;
	  }
}
	
class book2{
	  String bk;
	  book2(String book){
		  bk = book;
	  }
}

class book3{
	  String bk;
	  book3(String book){
		  bk = book;
	  }
} class dryTest {
	

  
  
	public static void main(String[] args){

		MyServlet servlet = new MyServlet();
		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		HttpServletResponse mockResponse = mock(HttpServletResponse.class);

		StringWriter out = new StringWriter();
		PrintWriter printOut = new PrintWriter(out);
		when(mockResponse.getWriter()).thenReturn(printOut);

		servlet.doGet(mockRequest, mockResponse);

		verify(mockResponse).setStatus(200);
		assertEquals("my content", out.toString());	
		
		
		
		
}
}
