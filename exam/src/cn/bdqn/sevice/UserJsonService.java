package cn.bdqn.sevice;
import java.util.List;
import cn.bdqn.dao.UserJsonDao;
import cn.bdqn.entity.UserBean;


//�û�ҵ���
public class UserJsonService {
	
	UserJsonDao dao = new UserJsonDao();
    
	//��ѯ�����û�
	public List<UserBean> finall() {
		return dao.finall();
	}

}
