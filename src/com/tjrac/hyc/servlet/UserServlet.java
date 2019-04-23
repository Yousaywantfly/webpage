package com.tjrac.hyc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tjrac.hyc.pojo.Product;
import com.tjrac.hyc.pojo.Save;
import com.tjrac.hyc.pojo.User;
import com.tjrac.hyc.service.ProductService;
import com.tjrac.hyc.service.SaveService;
import com.tjrac.hyc.service.UserService;
import com.tjrac.hyc.service.impl.ProductServiceImpl;
import com.tjrac.hyc.service.impl.SaveServiceImpl;
import com.tjrac.hyc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userservice;
	private SaveService saveservice;
	private ProductService proservice;

	public UserServlet() throws IOException {
		super();
		this.userservice = new UserServiceImpl();
		this.saveservice = new SaveServiceImpl();
		this.proservice = new ProductServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 接受请求参数
		String op = request.getParameter("op");
		if ("login".equals(op)) {
			login(request, response);
		} else if ("save".equals(op)) {
			save(request, response);
		} else if ("delete".equals(op)) {
			delete(request, response);
		} else if ("show".equals(op)) {
			show(request, response);
		} else if ("select".equals(op)) {
			select(request, response);
		}else if("selectall".equals(op)) {
			selectall(request,response);
		}
	}

	private void selectall(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		List<Product> list = this.proservice.selectall();
		JSONArray bb = new JSONArray(list);
		out.print(bb);
	}

	private void select(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println("来了");
		PrintWriter out = response.getWriter();
		String pname = request.getParameter("name");
		System.out.println(pname);
		List<Product> list = this.proservice.selectByname(pname);
		JSONArray aa = new JSONArray(list);
		out.print(aa);
	}

	private void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User s = (User) session.getAttribute("user");
		Save save = new Save();
		save.getUser().setUid(s.getUid());
		List<Save> l = this.saveservice.show(save);
		session.setAttribute("l", l);
		response.sendRedirect(this.getServletContext().getContextPath() + "/html/show.jsp");
		System.out.println(l);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User s = (User) session.getAttribute("user");
		int i = Integer.parseInt(request.getParameter("op1"));
		Save save = new Save();
		save.getUser().setUid(s.getUid());
		save.getPro().setPid(i);
		boolean b = this.saveservice.delete(save);
		if (b) {
			response.sendRedirect(this.getServletContext().getContextPath() + "/html/main.jsp");
		}
	}
//添加收藏
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("save");
		JSONObject obj = new JSONObject();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		User s = (User) session.getAttribute("user");
		int i = Integer.parseInt(request.getParameter("op1"));
//		System.out.println(s);

		Save save = new Save();
		save.getUser().setUid(s.getUid());
		save.getPro().setPid(i);
		save.setSave_time(new Date());
		boolean c = this.saveservice.selectsave(save);
		if (c) {
			boolean b = this.saveservice.save(save);
			obj.put("flag", true);
		} else {
			obj.put("flag", false);
		}
		out.print(obj);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("来了");
		String uname = request.getParameter("username");
		String upassword = request.getParameter("password");
		System.out.println(uname + "   " + upassword);
		User user = new User();
		user.setUname(uname);
		user.setUpassword(upassword);
		JSONObject obj = new JSONObject();
		User b = this.userservice.judge(user);
		PrintWriter out = response.getWriter();
		if (b != null) {
			obj.put("flag", true);
			HttpSession session = request.getSession();
			session.setAttribute("user", b);
		} else {
			obj.put("flag", false);
		}
		out.print(obj);
		out.flush();
	}

}
