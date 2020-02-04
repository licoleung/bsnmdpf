# 食品公司业务中台
<hr>
<h3>注意事项*</h3>
<h4>1.vipcenter端口改为5080</h4>
<h4>2.消费者调用UserCenterService的时候会存在传输pojo实体类的情况，例如添加用户、部门等，</h4>
<h4>&nbsp;&nbsp;&nbsp;但当调用VIPCenterService的时候传输的是各个字段参数，pojo实体类的封装会在VIPCenter里面完成。</h4>
<hr>
<h3>版本信息</h3>
V5.2<br>  2020年2月5日 00点50分<br> ·完成StockController，已增加List字段，已关联仓位<br><br>
V5.1<br>  2020年2月4日 23点09分<br> ·完成stockcenter的service<br><br>
V5.0<br>  2020年2月4日 17点21分<br> ·完成仓库和仓位的service,但仓库未关联仓位，未增加List字段<br><br>
V4.2<br>  2020年2月4日 15点10分<br> ·完成vipcenter在api的service<br>·添加了注意事项<br>·在DepartmentController添加了注解<br>·在UserCenterService添加了注解<br><br>
V4.1<br>  2020年2月4日 14点54分<br> ·完成vipcenter绝大部分的CRUD<br><br>
V4.0<br>  2020年2月3日 23点56分<br> ·完成vipcenter的基本CRUD<br><br>
V3.1<br>  ·完成usercenter在api的service<br><br>
V3.0<br>  ·因spring security出现问题，复原了项目，添加了9001消费者及8001网关<br><br>
V2.0<br>  ·基本完成usercenter的增删查改，但凡是设计多表关系的仍然未处理<br>·修改了之前的小bug，role的isActive的类型从string修改为integer<br><br>
V1.2<br>  ·更新user的service及controller<br><br>
V1.1<br>  ·新建api，将所有pojo统一管理<br><br>
V1.0<br>  2020-01-27 13:03<br> ·搭建初步框架，完成基本的数据库设计
