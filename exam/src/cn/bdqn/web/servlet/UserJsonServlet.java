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
//�û���ҵ���
public class UserJsonServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3717358908011149439L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //�����Ͷ���utf-8 
		 request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         String parameter = request.getParameter("excel");
         //��ѯ�û���Ϣ
     	 List<UserBean> list = new UserJsonService().finall();
     	 //��װ�õ��û���Ϣ�ŵ�json�з���ǰ̨
     	 String json = null;
     	 json = JSON.toJSONString(list);
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
