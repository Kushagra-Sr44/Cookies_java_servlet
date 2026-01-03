package com.Cookies;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class process extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
			throws IOException, ServletException{
		Cookie[] ck=req.getCookies();
		String name=req.getParameter("n");
		boolean vist=false;
		PrintWriter out=res.getWriter();
		if(ck!=null) {
			for(int i=0;i<ck.length;i++) {
				Cookie c=ck[i];
				if(c.getName().equals("k")&&c.getValue().equals("123")) {
					out.print("Welcome Back "+name);
					vist=true;
					break;
				}
				
			}
			
		}
		else if(vist==false){
			out.print("Welcome "+name);
			Cookie ci=new Cookie("k","123");
			res.addCookie(ci);
		}
		
	}
	}