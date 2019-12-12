package cn.bdqn.sevice;

import java.util.List;

import cn.bdqn.dao.ExcelImportDao;
import cn.bdqn.entity.UserBean;

public class ExcelImportService {
  
	//保存导入的信息
	public void save(List<UserBean> list) {
	   new ExcelImportDao().save(list);
	}

}
