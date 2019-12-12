package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.bdqn.entity.Paper;
import cn.bdqn.sevice.PaperService;
import cn.bdqn.sevice.impl.PaperServiceImpl;

@WebServlet("/paper")
public class PaperServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8343799283438355753L;

	private PaperService paper = new PaperServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String discern = req.getParameter("discern");
		try {
			if ("add".equals(discern)) {
				String paperName = req.getParameter("paperName");
				//创建试卷对象
				if (paperName!=null&&!"".equals(paperName.trim())) {
				Paper p = new Paper();
				p.setPaperName(paperName);
				//调用添加试卷的方法
				paper.insertPaper(p);
				//查询全部试卷列表
				List<Paper> pList = paper.queryPaper();
				//转换为json对象
				String pListJSON = JSONObject.toJSONString(pList);
				resp.getWriter().write(pListJSON);
				
				}
			}else if ("query".equals(discern)) {
				List<Paper> pList = paper.queryPaper();
				//转换为json对象
				String pListJSON = JSONObject.toJSONString(pList);
				resp.getWriter().write(pListJSON);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
