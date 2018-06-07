# 项目简介



# 2018年6月5日

后台管理系统工程结构：
taotao-parent -- 管理依赖jar包的版本，全局，公司级别
	|--taotao-common  --- 通用组件、工具类
	|--taotao-manage  -- (聚合工程)后台系统
 		|--com.taotao.manage.web
  		|--com.taotao.manage.service
  		|--com.taotao.manage.mapper
  		|--com.taotao.manage.pojo


# 2018年6月6日 

目标：商品列表的查询

- 框架整合springmvc+spring+mybatis

  - Dao层：使用MyBatis框架。创建SqlMapConfig.xml文件
  - 创建一个application-dao.xml配置文件
    - 配置数据源。
    - 需要让Spring容器管理SqlSessionFactory，单例存在。
    - 把mapper的代理对象放到spring容器中。使用扫描包的方式加载mapper的代理对象
  - Services层：
    - 事务管理
    - 需要把这个services实现类对象放到Spring容器中，使用扫描包的方式。
  - Controller表现层：
    - 使用注解驱动
    - 配置视图解析器
    - 配置扫描Controller
  - Web.xml配置
    - Spring容器的配置
    - SpringMVC前端控制器的配置
    - Post乱码过滤器

- 创建数据库

  在互联网行业的项目中，尽可能的减少表的管理查询。使用冗余解决表的关联问题。有利于分库分表。

- 使用mybatis的逆向工程生成代码

  MyBatis的逆向工程，根据数据库的表生成Java代码。

- 商品列表功能实现

# 2018年6月7日

## 整合思路

>  需要把配置文件放到taotao-manager-web工程下。因为此工程为war工程，其他的工程只是一个jar包 。

添加添加相关配置文件，加入静态资源。

测试