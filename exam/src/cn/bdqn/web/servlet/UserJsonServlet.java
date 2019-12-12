package cn.bdqn.web.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.bdqn.entity.UserBean;
import cn.bdqn.sevice.UserJsonService;
import com.alibaba.fastjson.JSON;
//用户的业务层
public class UserJsonServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3717358908011149439L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //请求发送都是utf-8 
		 request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         String parameter = request.getParameter("excel");
         //查询用户信息
     	 List<UserBean> list = new UserJsonService().finall();
     	 //封装好的用户信息放到json中返回前台
     	 String json = null;
     	 json = JSON.toJSONString(list);
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
