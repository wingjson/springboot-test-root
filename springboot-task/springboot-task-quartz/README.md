# springboot-task-quartz

##定时任务实现的几种方式：
 
 * 1、Timer：这是java自带的java.util.Timer类，这个类允许你调度一个java.util.TimerTask任务。使用这种方式可以让你的程序按照某一个频度执行，但不能在指定时间运行。一般用的较少。
 * 2、ScheduledExecutorService：也jdk自带的一个类；是基于线程池设计的定时任务类,每个调度任务都会分配到线程池中的一个线程去执行,也就是说,任务是并发执行,互不影响。
 * 3、Spring Task：Spring3.0以后自带的task，可以将它看成一个轻量级的Quartz，而且使用起来比Quartz简单许多。
 * 4、Quartz：这是一个功能比较强大的的调度器，可以让你的程序在指定时间执行，也可以按照某一个频度执行，配置起来稍显复杂

#### cron
* 首先附上-在线Cron表达式生成器: http://cron.qqe2.com
##### 0 0 3 * * ?    每天 3 点执行

* 第一位，表示秒，取值 0-59
* 第二位，表示分，取值 0-59
* 第三位，表示小时，取值 0-23
* 第四位，日期，取值 1-31
* 第五位，月份，取值 1-12
* 第六位，星期几，取值 1-7
* 第七位，年份，可以留空，取值 1970-2099

(*) 星号：可以理解为“每”的意思，每秒、没分
(?) 问好：只能出现在日期和星期这两个位置，表示这个位置的值不确定
(-) 表达一个范围，如在小时字段中使用 10-12 ，表示从10点到12点
(,) 逗号，表达一个列表值，如在星期字段中使用 1,2,4 ，则表示星期一、星期二、星期四
(/) 斜杠，如 x/y ，x是开始值，y是步长，如在第一位(秒)使用 0/15，表示从0秒开始，每15秒

官方解释：
0 0 3 * * ?         每天 3 点执行
0 5 3 * * ?         每天 3 点 5 分执行
0 5 3 ? * *         每天 3 点 5 分执行
0 5/10 3 * * ?      每天 3 点 5 分，15 分，25 分，35 分，45 分，55 分这几个点执行
0 10 3 ? * 1        每周星期天的 3 点10 分执行，注：1 表示星期天
0 10 3 ? * 1#3      每个月的第三个星期的星期天 执行，#号只能出现在星期的位置

注：第六位(星期几)中的数字可能表达不太正确，可以使用英文缩写来表示，如：Sun

### 文件对应解释
#### config 配置文件
* AsynConfig 自定义线程池-异步事件支持
* ExecutorConfig  配置默认线程池和动态创建定时任务（配合数据库动态执行）
* QuartzConfig 三种种配置Quartz方式:使用Trigger,使用 cron 表达式,动态设置任务-配合方式二, 与方式一有冲突,需要注释掉方式一
* ScheduledTaskConfig  Scheduled 动态定时任务调度
* Swagger2Config  wagger2测试
* TaskThreadPoolConfig 线程池的属性配置

#### controller 
* AlarmTaskController  AlarmTask简单测试
* QuartzTaskController 动态控制任务(暂停，启动，修改执行时间)
* ScheduledController Scheduled定时任务 功能有: 初始化任务列表、所有任务列表、启动任务、重启任务、停止任务
* TaskTimeController 动态定时任务在数据库中的配置

### 待测试
使用quartz框架（持久化到数据库+springboot）