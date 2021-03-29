Hello-MyBatis 入门实例及步骤
1.创建数据库表 student
2.POM文件中引入Maven的  MyBatis框架（gav）的依赖项 及  Mysql驱动（gav）的依赖项
3.创建实体类 student 保存表中一行数据 的模型
4.创建 dao持久层 接口 定义操作数据库的方法
5.创建MyBatis使用配置 文件 【SQL映射文件】 写SQL语句，一般一张表对应一个映射文件【xml文件】
6.创建MyBatis的主配置文件，其中存放 数据库的连接信息 及 SQL映射文件 的信息
7.创建使用MtBatis类 访问数据库