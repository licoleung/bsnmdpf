# 食品公司业务中台
<hr>
<h3>注意事项*</h3>
<h4>1.vipcenter端口改为5080</h4>
<h4>2.消费者调用UserCenterService的时候会存在传输pojo实体类的情况，例如添加用户、部门等，</h4>
<h4>&nbsp;&nbsp;&nbsp;但当调用VIPCenterService的时候传输的是各个字段参数，pojo实体类的封装会在VIPCenter里面完成。</h4>
<h4>3.所有“体积”的单词写成了“volumn”，涉及地方过多，不作修改</h4>
<hr>
<h3>剩余任务</h3>
<h4>1.user中心的相关页面及登录问题</h4>
<h4>2.vip充值及积分兑换问题</h4>
<h4>3.echarts展示数据</h4>
<hr>
<h3>版本信息</h3>
V15.1<br> 2020年2月28日 20点49分<br> ·完成登录及权限管理<br><br>
V15.0<br> 2020年2月27日 22点45分<br> ·修改了多个中心的pom,修改了user和role,准备加入spring security<br><br>
V14.1<br> 2020年2月27日 19点16分<br> ·完成优惠券的页面<br><br>
V14.0<br> 2020年2月26日 23点11分<br> ·完成活动的页面<br>·解决了网关跳转问题<br><br>
V13.1<br> 2020年2月25日 23点02分<br> ·完善了goodCenter以及相关页面<br>·修改了zuul网关配置（页面跳转有问题，需要进一步处理）<br><br>
V13.0<br> 2020年2月25日 00点10分<br> ·找到了展示货物的基本解决方案<br>·修改了goodCenter部分小bug<br><br>
V12.1<br> 2020年2月24日 18点43分<br> ·修改zuul网关配置<br><br>
V12.0<br> 2020年2月24日 18点29分<br> ·大致完成stock模块<br>·大致完成pay模块，及修改相关bug<br><br>
V11.0<br> 2020年2月22日 23点31分<br> ·大致完成订单模块<br>·完成库存模块的入库单、出库单、现存量<br><br>
V10.2<br> 2020年2月22日 00点41分<br> ·完善了OrderBaseController及相关页面<br><br>
V10.1<br> 2020年2月21日 01点25分<br> ·增加了OrderBaseController<br>·增加了purchase-order列表页面<br>·修改vip页面、修改vipBaseController<br>·修改ordercenter之前缺少的requestparam(required=false)<br><br>
V10.0<br> 2020年2月19日 15点47分<br> ·增加了VIPBaseController<br>·增加了首页、vip列表页面、修改vip页面<br><br>
V9.1<br> 2020年2月12日 20点06分<br> ·修改了SaleCenter小bug，无添加required=false<br><br>
V9.0<br> 2020年2月12日 15点19分<br> ·完成SaleCenter<br><br>
V8.2<br> 2020年2月10日 20点27分<br> ·完成PayCenter<br><br>
V8.1<br> 2020年2月10日 15点02分<br> ·基本完成对支付的处理，简单接入了支付宝，缺少对SalebillController的进一步编写<br><br>
V8.0<br> 2020年2月9日 23点41分<br> ·正在完善paycenter<br>·修改了eureka相关配置<br><br>
V7.3<br> 2020年2月9日 16点49分<br> ·完成OrderCenter<br><br>
V7.2<br> 2020年2月9日 01点21分<br> ·完成了orderCenter中的service，以及PurchaseorderController<br><br>
V7.1<br> 2020年2月7日 23点13分<br> ·修改了purchaseorder中money的小bug，将String改为Double<br>·增加了PurchaseorderService，只写了add方法<br><br>
V7.0<br> 2020年2月7日 22点50分<br> ·修改了OrderCenter的pojo<br><br>
V6.1<br> 2020年2月7日 20点14分<br> ·完成GoodCenter<br><br>
V6.0<br>  2020年2月6日 23点57分<br>  ·Material的修改及MaterialService的编写<br><br>
V5.6.1<br> 2020年2月6日 16点05分<br> ·修改了事务管 理的小bug<br><br>
V5.6<br>  2020年2月6日 15点51分<br> ·优化了VIPCenter及UserCenter的事务管理<br><br>
V5.5<br>  2020年2月6日 15点32分<br> ·完成StockCenter，含事务管理<br>·完成VIPCenter日期的处理<br><br>
V5.4<br>  2020年2月5日 23点18分<br> ·完成stockcenter大部分<br><br>
V5.3<br>  2020年2月5日 12点35分<br> ·完成WarehouseController，部分InstockbillController<br><br>
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
