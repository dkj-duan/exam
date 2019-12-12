package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bdqn.entity.Paper;
import cn.bdqn.sevice.PaperService;
import cn.bdqn.sevice.impl.PaperServiceImpl;

@WebServlet("/openPapers")
public class OpenAddtionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6307741117319348081L;

	private PaperService paper = new PaperServiceImpl();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.getParameter("UTF-8");
		try {
			List<Paper> papers = paper.queryPaper();
			//设置作用域
			HttpSession se = req.getSession();
			se.setAttribute("pspers", papers);
			//重定向
			resp.sendRedirect("newAddition.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
