package cn.bdqn.sevice;
import java.util.List;
import cn.bdqn.dao.UserJsonDao;
import cn.bdqn.entity.UserBean;


//用户业务层
public class UserJsonService {
	
	UserJsonDao dao = new UserJsonDao();
    
	//查询所有用户
	public List<UserBean> finall() {
		return dao.finall();
	}

}
