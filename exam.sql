/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.48 : Database - exam
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`exam` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `exam`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'adminid',
  `adminName` varchar(20) NOT NULL COMMENT '管理员姓名',
  `adminPwd` varchar(100) NOT NULL COMMENT '管理员密码',
  `adminEmail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `adminCardId` varchar(30) NOT NULL COMMENT '身份证号',
  `adminPhone` varchar(20) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`adminId`,`adminName`,`adminPwd`,`adminEmail`,`adminCardId`,`adminPhone`) values (2,'段康家','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','411421199807222117','18736823860'),(3,'彭依凝','e10adc3949ba59abbe56e057f20f883e','232133@qq.com','4112234567876543234','18736823860'),(4,'张子森','e10adc3949ba59abbe56e057f20f883e','21312@qq.ddd','411421199807222117','18736823860'),(5,'史周冲','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','4112234567876543234','18736823860'),(6,'杨老师','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','123456','18736823860'),(7,'123','81dc9bdb52d04dc20036dbd8313ed055','232133@qq.com','411421199807222117','18736823860');

/*Table structure for table `t_answer` */

DROP TABLE IF EXISTS `t_answer`;

CREATE TABLE `t_answer` (
  `answerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '答案编号',
  `issueId` int(11) NOT NULL COMMENT '考题编号',
  `answer` varchar(20) NOT NULL COMMENT '标准答案选项',
  PRIMARY KEY (`answerId`)
) ENGINE=InnoDB AUTO_INCREMENT=377 DEFAULT CHARSET=utf8;

/*Data for the table `t_answer` */

insert  into `t_answer`(`answerId`,`issueId`,`answer`) values (350,355,'b'),(351,356,'a'),(352,357,'d'),(353,358,'c'),(354,359,'c'),(355,360,'b'),(356,361,'b'),(357,362,'c'),(358,363,'a'),(359,364,'a'),(360,365,'a'),(361,366,'b'),(362,367,'d'),(363,368,'a,b'),(364,369,'a,b,c,d'),(365,370,'a,b'),(366,371,'a'),(367,372,'d'),(368,373,'d'),(369,374,'a'),(370,375,'a,b'),(371,376,'c'),(372,377,'c'),(373,378,'c'),(374,379,'b,c'),(375,380,'b'),(376,381,'a');

/*Table structure for table `t_exam` */

DROP TABLE IF EXISTS `t_exam`;

CREATE TABLE `t_exam` (
  `issueId` int(11) NOT NULL AUTO_INCREMENT COMMENT '考题编号',
  `issueText` varchar(200) NOT NULL COMMENT '考试内容',
  `issueType` int(11) NOT NULL COMMENT '考试类型1单选、2多选',
  `score` int(11) DEFAULT '5' COMMENT '考题分数',
  `answerA` varchar(200) NOT NULL COMMENT '答案A',
  `answerB` varchar(200) NOT NULL COMMENT '答案B',
  `answerC` varchar(200) NOT NULL COMMENT '答案C',
  `answerD` varchar(200) NOT NULL COMMENT '答案D',
  PRIMARY KEY (`issueId`)
) ENGINE=InnoDB AUTO_INCREMENT=382 DEFAULT CHARSET=utf8;

/*Data for the table `t_exam` */

insert  into `t_exam`(`issueId`,`issueText`,`issueType`,`score`,`answerA`,`answerB`,`answerC`,`answerD`) values (355,'求救信号是？',1,5,'ccc','sos','ccc','awc'),(356,'数据库的作用是？',1,5,'存数据','打游戏','听音乐','看电影'),(357,'S225班有多少人？',1,5,'\"22\"','\"25\"','\"26\"','\"28\"'),(358,'S225班有几个女生？',1,5,'\"2\"','\"4\"','\"5\"','\"6\"'),(359,'Tomcat默认端口号为？',1,5,'\"8181\"','\"3366\"','\"8080\"','\"1234\"'),(360,'郑州什么时候开始垃圾分类？',1,5,'\"2019/12/3\"','\"2019/12/1\"','\"2019/12/15\"','\"2019/12/30\"'),(361,'在c#中定义一个虚方法的关键字是？',1,5,'public','virtual','abstract','implicit'),(362,'关于实现多态下面哪个选项是不正确的',1,5,'多态','可以通过继承实现多态','可以通过封装实现多态','可以通过使用抽象类'),(363,'在java中，程序员可以在子类的构造方法中使用关键字()调用父类的构造方法',1,5,'super','this','extends','implements'),(364,'在java中，下面关于构造方法描述正确的是？',1,5,'构造方法在new时候执行','构造方法不能带有参数','类只能有一个构造方法','构造方法的返回类型是void'),(365,'以下关于构造方法的描述错误的是',1,5,'构造方法在任何时候执行','构造方法是类的一种特殊方法，它的方法名必须与类名相同','构造方法的主要作用是完成对类的对象的初始化工作','一般在创建新对象时，系统会自动调用构造方法'),(366,'关键字()是java提供的一个关键字，它是直接父类对象的默认引用',1,5,'public','super','final','overrid'),(367,'下列哪个不是java中面向对象程序设计方法的特点',1,5,'接口','继承','多态','结构化'),(368,'java中，下列哪个修饰符是既可以修饰类也可以修饰接口的',2,5,'public','abstract','final','void'),(369,'java中，面向接口编程好处有',2,5,'面向接口','更加面向对象','提高编程的灵活性','提高可维护性降低耦合'),(370,'在Java接口中，下列选项中有效的方法声明是（）。（选择二项）',2,5,'public void aMethod();','void aMethod();','protected void aMethod();','private void aMethod();'),(371,'在JAVA的异常处理模型中，能单独和finally语句一起使用的块是（）。',1,5,'try','catch','throw','throws'),(372,'在JAVA中，Object类是所有类的父亲，用户自定义类默认扩展自Object类，下列选项中的（）方法不属于Object类的方法。',1,5,'equals(Object obj)','getClass()','toString()','trim()'),(373,'下列选项中关于Java中封装的说法错误的是（）。',1,5,'封装就是将属性私有化，提供共有的方法访问私有属性','属性的访问方法包括setter方法和getter方法','setter方法用于赋值，getter方法用于取值','包含属性的类都必须封装属性，否则无法通过编译'),(374,'Java中，如果类C是类B的子类，类B是类A的子类，那么下面描述正确的是（）',1,5,'C不仅继承了B中的成员，同样也继承了A中的成员',' C只继承了B中的成员',' C只继承了A中的成员','C不能继承A或B中的成员'),(375,'立刻解开了大家',1,5,'zhangsan','2','3','21321'),(376,' 在Java中,关于构造方法，下列说法错误的是( )',1,5,' 构造方法的名称必须与类名相同','构造方法可以带参数',' 构造方法不可以重载','构造方法绝对不能有返回值'),(377,'下面（）不是String类提供的合法的方法。',1,5,'equals(String)','trim()','append()','indexOf()'),(378,'在JAVA中，以下（ ）类的对象以键-值的方式存储对象',1,5,' java.util.List','java.util.ArrayList',' java.util.HashMap','java.util.LinkedList'),(379,'在Java中，下面对于构造函数的描述错误的是（）（选择两项）',2,5,'类不一定要显式定义构造函数','构造函数的返回类型是void',' 如果构造函数不带任何参数，那么构造函数的名称和类名可以不同','一个类可以定义多个构造函数'),(380,'在Java语言中，下列关于类的继承的描述，正确的是（）',1,5,'一个类可以继承多个父类','一个类可以具有多个子类','子类可以使用父类的所有方法','子类一定比父类有更多的成员方法'),(381,'下列选项中关于Java中super关键字的说法正确的是（）。',1,5,'super关键字是在子类对象内部指代其父类对象的引用','super关键字不仅可以指代子类的直接父类，还可以指代父类的父类','子类通过super关键字只能调用父类的方法，而不能调用父类的属性','子类通过super关键字只能调用父类的属性，而不能调用父类的方法');

/*Table structure for table `t_fzexam` */

DROP TABLE IF EXISTS `t_fzexam`;

CREATE TABLE `t_fzexam` (
  `paperId` int(11) NOT NULL COMMENT '试卷id',
  `issueId` int(11) NOT NULL COMMENT '考题编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_fzexam` */

/*Table structure for table `t_grade` */

DROP TABLE IF EXISTS `t_grade`;

CREATE TABLE `t_grade` (
  `stuId` int(11) NOT NULL COMMENT '学生编号',
  `paperName` varchar(20) NOT NULL DEFAULT '随机试卷' COMMENT '试卷名称',
  `stuGrade` int(11) NOT NULL COMMENT '学生成绩',
  `examTime` datetime NOT NULL COMMENT '考试时间',
  `accuracy` varchar(20) NOT NULL COMMENT '正确率'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_grade` */

insert  into `t_grade`(`stuId`,`paperName`,`stuGrade`,`examTime`,`accuracy`) values (1,'随机试卷',60,'2019-11-02 13:08:48','60.0'),(1,'Java试卷1',45,'2019-11-02 13:10:17','45.0'),(8,'随机试卷',30,'2019-11-02 15:11:18','30.0'),(8,'Java试卷1',25,'2019-11-02 15:14:08','25.0');

/*Table structure for table `t_newexam` */

DROP TABLE IF EXISTS `t_newexam`;

CREATE TABLE `t_newexam` (
  `issueId` int(11) NOT NULL AUTO_INCREMENT COMMENT '考题编号',
  `issueText` varchar(200) NOT NULL COMMENT '考试内容',
  `issueType` int(11) NOT NULL COMMENT '考试类型1单选、2多选',
  `score` int(11) NOT NULL COMMENT '考题分数',
  `paperId` int(11) NOT NULL COMMENT '试卷id',
  `answerA` varchar(200) NOT NULL COMMENT '答案A',
  `answerB` varchar(200) NOT NULL COMMENT '答案B',
  `answerC` varchar(200) NOT NULL COMMENT '答案C',
  `answerD` varchar(200) NOT NULL COMMENT '答案D',
  `answer` varchar(20) NOT NULL COMMENT '标准答案选项',
  PRIMARY KEY (`issueId`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*Data for the table `t_newexam` */

insert  into `t_newexam`(`issueId`,`issueText`,`issueType`,`score`,`paperId`,`answerA`,`answerB`,`answerC`,`answerD`,`answer`) values (28,'Java语言支持的8中基本数据类型是：',2,5,1,'byte','int','double','char','a,b,c,d'),(29,'JAVA所定义的版本中不包括',1,5,1,' JAVA2 EE','JAVA2 Card','JAVA2 ME','JAVA2 HE','d'),(30,'下列说法正确的是',1,5,1,'JAVA程序的main方法必须写在类里面','JAVA程序中可以有多个main方法','JAVA程序中类名必须与文件名一样','JAVA程序的main方法中如果只有一条语句，可以不用{}(大括号)括起来','a'),(31,'变量命名规范说法正确的是',2,5,1,'变量由字母、下划线、数字、$符号随意组成；','变量不能以数字作为开头；',' A和a在java中不是同一个变量；','不同类型的变量，可以起相同的名字；','b,c'),(32,'下列javaDoc注释正确的是',1,5,1,'/*我爱北京天安门*/','//我爱北京天安门*/','/**我爱北京天安门*/','/*我爱北京天安门**/','c'),(33,' 为一个boolean类型变量赋值时，可以使用()方式',1,5,1,' boolean = 1;','boolean a = (9 >= 10);','boolean a=\"真\";','boolean a = = false;','b'),(34,'以下()不是合法的标识符',1,5,1,' STRING','x3x;','void','de$f','c'),(35,'表达式(11+3*8)/4%3的值是()',1,5,1,' 31','0','1','2','d'),(36,'（）表达式不可以作为循环条件',1,5,1,'i++;','i>5;',' bEqual = str.equals(\"q\");','count = = i;','a'),(37,'运算符优先级别排序正确的是（）',1,5,1,' 由高向低分别是：()、!、算术运算符、关系运算符、逻辑运算符、赋值运算符；',' 由高向低分别是：()、关系运算符、算术运算符、赋值运算符、!、逻辑运算符；','由高向低分别是：()、算术运算符、逻辑运算符、关系运算符、!、赋值运算符；','由高向低分别是：()、!、关系运算符、赋值运算符、算术运算符、逻辑运算符；','a'),(38,'下列值不为true的表达式有',2,5,1,' \"john\" = = \"john\"','\"john\".equals(\"john\")','\"john\" = \"john\"','\"1>1\"','c,d'),(39,'下面有关for循环的描述正确的是（）',1,5,1,'for循环体语句中，可以包含多条语句，但要用大括号括起来','for循环只能用于循环次数已经确定的情况','在for循环中，不能使用break语句跳出循环','for循环是先执行循环体语句，后进行条件判断','a'),(40,'下列（）属于引用数据类型（选择两项）',2,5,1,' String',' char','用户自定义的Student类类型','int','a,c'),(41,' 对象的特征在类中表示为变量，称为类的（）。',1,5,1,'对象','属性','方法','数据类型','b'),(42,'在java中下列关于自动类型转换说法正确的是（）',1,5,1,'基本数据类型和String相加结果一定是字符串型','char类型和int类型相加结果一定是字符','double类型可以自动转换为int','char + int + double +\"\" 结果一定是double；','a'),(43,'关于类的描叙正确的是（）（选择两项）',2,5,1,' 在类中定义的变量称为类的成员变量，在别的类中可以直接使用','局部变量的作用范围仅仅在定义它的方法内，或者是在定义它的控制流块中','使用别的类的方法仅仅需要引用方法的名字即可',' 一个类的方法使用该类的另一个方法时可以直接引用方法名','b,d'),(44,'下列关于字符串的描叙中错误的是（）（选择两项）',1,5,1,'字符串是对象','String对象存储字符串的效率比StringBuffer高','可以使用StringBuffer sb=\"这里是字符串\"声明并初始化StringBuffer对象sb','String类提供了许多用来操作字符串的方法：连接，提取，查询等','b,c'),(45,'以下（）代码，能够对数组正确初始化（或者是默认初始化）。',1,5,1,' int[] a;',' a = {1, 2, 3, 4, 5};','int[] a = new int[5]{1, 2, 3, 4, 5};','int[] a = new int[5];','d'),(46,'下面关于数组的说法中，错误的是（）（选择两项）',2,5,1,' 在类中声明一个整数数组作为成员变量，如果没有给它赋值，数值元素值为空','数组可以在内存空间连续存储任意一组数据','数组必须先声明，然后才能使用','数组本身是一个对象','a,b'),(47,'在Java中,关于构造方法，下列说法错误的是( )',1,5,1,'构造方法的名称必须与类名相同','构造方法可以带参数','构造方法不可以重载','构造方法绝对不能有返回值','c'),(48,'dslmdsasm;ladsa',2,5,16,'1221','1221','1221','1221','a,b');

/*Table structure for table `t_paper` */

DROP TABLE IF EXISTS `t_paper`;

CREATE TABLE `t_paper` (
  `paperId` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `paperName` varchar(30) NOT NULL COMMENT '试卷名称',
  PRIMARY KEY (`paperId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `t_paper` */

insert  into `t_paper`(`paperId`,`paperName`) values (1,'Java试卷1'),(16,'JSP'),(18,'HTML');

/*Table structure for table `t_stuanswer` */

DROP TABLE IF EXISTS `t_stuanswer`;

CREATE TABLE `t_stuanswer` (
  `stuId` int(11) NOT NULL COMMENT '学生id',
  `issueId` int(11) NOT NULL COMMENT '考题编号',
  `paperId` int(11) NOT NULL COMMENT '试卷id',
  `stuAnswer` varchar(20) DEFAULT NULL COMMENT '学生答案'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_stuanswer` */

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `stuId` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `stuName` varchar(20) NOT NULL COMMENT '学生姓名',
  `stuPwd` varchar(100) NOT NULL COMMENT '学生密码',
  `stuEmail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `stuCardId` varchar(30) NOT NULL COMMENT '身份证号',
  `stuPhone` varchar(20) NOT NULL COMMENT '手机号',
  PRIMARY KEY (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`stuId`,`stuName`,`stuPwd`,`stuEmail`,`stuCardId`,`stuPhone`) values (1,'段康家','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','411421199807222117','18736823860'),(2,'彭依凝','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','4112234567876543234','18736823860'),(3,'张子森','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','411421199807222117','18736823860'),(4,'史周冲','e10adc3949ba59abbe56e057f20f883e','21312@qq.ddd','43423456765678765','18736823860'),(5,'老郭','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','411421199807222117','18736823860'),(6,'杨老板','e10adc3949ba59abbe56e057f20f883e','1597521668@qq.com','411421199807222117','18736823860'),(7,'admin','e10adc3949ba59abbe56e057f20f883e','21@qq.com','411421199807222117','18736823860'),(8,'郭仔','81dc9bdb52d04dc20036dbd8313ed055','1597521668@qq.com','411421199807222117','18736823860');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
