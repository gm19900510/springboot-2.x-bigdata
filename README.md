# springboot-2.x-bigdata

此项目采用`SpringBoot 2.x` + `Mybatis` + `dynamic-datasource-spring-boot-starter` + `mybatis-plus-boot-starter`进行多数据源集成及数据源动态切换 ，数据源包括：`Hive`、`Hbase`、`Postgresql`

利用`Hive`、`Impala`、`Presto`组件通过`JDBC`方式操作`Hive`

利用`Phoenix`组件通过`JDBC`方式操作`Hbase`

## 项目说明
  
- `Hadoop`集群、`Hive`、`Impala`安装

	请参照：

	https://gaoming.blog.csdn.net/article/details/107399914
	
	https://gaoming.blog.csdn.net/article/details/107516702

- `Presto`安装

	请参照：https://gaoming.blog.csdn.net/article/details/108194479

- `Phoenix`安装

## 集群环境说明

IP     | HOSTNAME 
-------- | -----
192.168.3.197  | S0
192.168.3.18  | S1
192.168.3.161  | S2
192.168.3.136  | S3



组件名称     | 版本 
-------- | -----
Hadoop  | 	2.6.0-cdh5.16.2
hive  | 1.1.0-cdh5.16.2
Hbase  | 1.2.0-cdh5.16.2
Presto  | 0.232-CC1019C
Impala  | 2.12.0-cdh5.16.2
Phoenix  | 4.14.1-cdh5.16.2.p0.1216424

## 项目访问

	
- 请访问：http://127.0.0.1:8080/swagger-ui.html#/ 

## 重要说明

- ***各驱动版本必须与集群中的组件版本对应***

- `Hive`开启显示列名/表头：`set hive.cli.print.header=true;`

- 多数据源及`Mybatis Plus`参考地址：

	https://baomidou.com/guide/dynamic-datasource.html
	https://baomidou.oschina.io/mybatis-plus-doc/#/spring-boot

- `Impala JDBC`驱动
  
  https://www.cloudera.com/downloads/connectors/impala/jdbc/2-6-4.html



- `Phoenix JDBC` 驱动 `shade-phoenix-client-4.14.1-HBase-1.2.jar`
	
	`springfox-swagger2` 依赖`com.google.guava 18.0`以上版本

	`phoenix-client` 和 `hive-jdbc` 依赖`com.google.guava 16.0`以下版本

	`guava 17.0` 为临界版本，做了较大改动，导致版本不兼容

	因`phoenix-client`将依赖打包至JAR内，无外部依赖，且冲突严重，顾需解决，方案：利用`maven-shade-plugin`，把依赖的包打包进项目的jar，并且`重新命名依赖包的包名`，`将部分依赖排除`，这样编译后形成`shade-phoenix-client-4.14.1-HBase-1.2.jar`

	***参照项目：[shade-phoenix-client](https://github.com/gm19900510/shade-phoenix-client)，通过`mvn package`将生成的`JAR`并复制到本项目的`libs`目录下。***

-  `Presto JDBC` 驱动 `presto-jdbc-0.232.jar`

	https://repo1.maven.org/maven2/com/facebook/presto/presto-server/ 
	```
	wget -c -t 0 https://repo1.maven.org/maven2/com/facebook/presto/presto-jdbc/0.232/presto-jdbc-0.232.jar
	```

- `Hive JDBC`驱动 `HiveJDBC41.jar`
	
	https://www.cloudera.com/downloads/connectors/hive/jdbc/2-6-2.html

- 出现`Error: ERROR 203 (22005): Type mismatch. INTEGER cannot be coerced to VARCHAR (state=22005,code=203)`异常的解决方案：
  注意定义类型与输入类型要匹配。
  
 - `Phoenix JDBC`方式查询库下的表时，不能使用`!tables`，需要使用`select TABLE_NAME "Table" from SYSTEM.CATALOG where TABLE_TYPE='u'`，特别需要注意`列的别名需要用双引号包围`。

- `Hive、Impala、Presto`中的`show tables`和`Phoenix`中的`!tables`在`Mapper`中使用时，均出现异常，顾采用`JdbcTemplate`方式进行`JDBC`操作。


- 在`Phoenix`中创建表的时候最后加上`COLUMN_ENCODED_BYTES= 0`或者`COLUMN_ENCODED_BYTES='NONE'`，可防止`scan`时，`列名无法正常显示的问题`。


- 在通过`Hive、Presto`执行`create table、drop table、alter table add column`等操作时需刷新元数据，使用`invalidate metadata [table]`语句

 