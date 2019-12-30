package cn.bdqn.controller;


import cn.bdqn.domain.Student;
import cn.bdqn.mapper.StudentMapper;
import cn.bdqn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
@SessionAttributes(value = {"stu"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login")
    public String register(String stuName , String stuPwd, ModelMap modelMap){
        System.out.printf("啊哈哈啥");
        Student student = studentService.queryByStuNameAndStuPwd(stuName,stuPwd);
        if (student == null){
            System.out.printf("啊哈哈啥111");
           return "message";
        }
        modelMap.addAttribute("stu",student);
        return "StudentMain";
    }


    @RequestMapping("/updatePwd")
    @ResponseBody
    public Map<String,String> updateStuPwd(Integer stuId,String pwd){
        Map<String,String> map = new HashMap<>();
        try{
            Student student = new Student();
            student.setStuid(stuId);
            student.setStupwd(pwd);
            studentService.updatePwd(student);

            map.put("mess","修改成功");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("mess","修改失败");
            return map;
        }


    }


}
