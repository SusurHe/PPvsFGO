package com.pp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pp.websocke.WebSocketSync;

/**
 * Servlet implementation class RoomUser
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RoomUser" })
public class RoomUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomUser() {
        super();
    }

	/**
	 * 前台调用此方法获取在线用户列表
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Set<String> users = WebSocketSync.getUser();
		StringBuffer str = new StringBuffer();
		for (String username : users) {
			str.append("<li><a href=# onclick=setReceiver(this)>" + username + "</a></li>");
		}
		PrintWriter out = response.getWriter();
		out.println(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



















