日期范围限制 
静态限制 
注意:日期格式必须与 realDateFmt 和 realTimeFmt 一致 
你可以给通过配置minDate(最小日期),maxDate(最大日期)为静态日期值,来限定日期的范围

示例4-1-1 限制日期的范围是 2006-09-10到2008-12-20
 
<input id="d411" class="Wdate" type="text" onfocus="WdatePicker({skin:'whyGreen',minDate: '2006-09-10', maxDate: '2008-12-20' })"/>

示例4-1-2 限制日期的范围是 2008-3-8 11:30:00 到 2008-3-10 20:59:30
 
<input type="text" class="Wdate" id="d412" onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm:ss', minDate: '2008-03-08 11:30:00', maxDate: '2008-03-10 20:59:30' })" value="2008-03-09 11:00:00"/>

示例4-1-3 限制日期的范围是 2008年2月 到 2008年10月
 
<input type="text" class="Wdate" id="d413" onfocus="WdatePicker({dateFmt: 'yyyy年M月', minDate: '2008-2', maxDate: '2008-10' })"/>

示例4-1-4 限制日期的范围是 8:00:00 到 11:30:00
 
<input type="text" class="Wdate" id="d414" onfocus="WdatePicker({dateFmt: 'H:mm:ss', minDate: '8:00:00', maxDate: '11:30:00' })"/>

动态限制 
注意:日期格式必须与 realDateFmt 和 realTimeFmt 一致 
你可以通过系统给出的动态变量,如%y(当前年),%M(当前月)等来限度日期范围,你还可以通过#{}进行表达式运算,如:#{%d+1}:表示明天

动态变量表

格式 说明 
%y  当前年 
%M  当前月 
%d  当前日 
%ld 本月最后一天 
%H  当前时 
%m  当前分 
%s  当前秒 
#{} 运算表达式,如:#{%d+1}:表示明天 
#F{} {}之间是函数可写自定义JS代码

示例4-2-1 只能选择今天以前的日期(包括今天)
 
<input id="d421" class="Wdate" type="text" onfocus="WdatePicker({skin:'whyGreen',maxDate: '%y-%M-%d' })"/>

示例4-2-2 使用了运算表达式 只能选择今天以后的日期(不包括今天)
 
<input id="d422" class="Wdate" type="text" onfocus="WdatePicker({minDate: '%y-%M-#{%d+1}' })"/>

示例4-2-3 只能选择本月的日期1号至本月最后一天
 
<input id="d423" class="Wdate" type="text" onfocus="WdatePicker({minDate: '%y-%M-01', maxDate: '%y-%M-%ld' })"/>

示例4-2-4 只能选择今天7:00:00至明天21:00:00的日期
 
<input id="d424" class="Wdate" type="text" onfocus="WdatePicker({dateFmt:'yyyy-M-d H:mm:ss',minDate: '%y-%M-%d 7:00:00', maxDate: '%y-%M-#{%d+1} 21:00:00' })"/>

示例4-2-5 使用了运算表达式 只能选择 20小时前 至 30小时后 的日期
 
<input id="d425" class="Wdate" type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate: '%y-%M-%d #{%H-20}:%m:%s' ,maxDate: '%y-%M-%d #{%H+30}:%m:%s' })"/>

脚本自定义限制 
注意:日期格式必须与 realDateFmt 和 realTimeFmt 一致 
系统提供了$dp.$D和$dp.$DV这两个API来辅助你进行日期运算,此外你还可以通过在 #F{} 中填入你自定义的脚本,做任何你想做的日期限制

示例4-3-1 前面的日期不能大于后面的日期且两个日期都不能大于 2020-10-01
合同有效期从  到  
<input id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'d4312\')||\'2020-10-01\'}' })"/> 
<input id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'d4311\')}' ,maxDate:'2020-10-01' })"/>

注意: 
两个日期的日期格式必须相同

$dp.$ 相当于 document.getElementByIdx_x 函数.
那么为什么里面的 ' 使用 \' 呢? 那是因为 " 和 ' 都被外围的函数使用了,故使用转义符 \ ,否则会提示JS语法错误.
所以您在其他地方使用时注意把 \' 改成 " 或者 ' 来使用.

#F{$dp.$D(\'d4312\')||\'2020-10-01\'} 表示当 d4312 为空时, 采用 2020-10-01 的值作为最大值

示例4-3-2 前面的日期+3天 不能大于 后面的日期
日期从  到  
<input type="text" class="Wdate" id="d4321" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'d4322\',{d:-3});}' })"/>
<input type="text" class="Wdate" id="d4322" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'d4321\',{d:3});}' })"/>

使用 $dp.$D 函数 可以将日期框中的值,加上定义的日期差量:
两个参数: id={字符类型}需要处理的文本框的id值 , obj={对象类型}日期差量 
日期差量用法: 
属性y,M,d,H,m,s分别代表年月日时分秒
如 
为空时,表示直接取值,不做差量(示例4-3-1中的参数就是空的)
{M:5,d:7} 表示 五个月零7天
{y:1,d:-3} 表示 1年少3天
{d:1,H:1} 表示一天多1小时

示例4-3-3 前面的日期+3月零2天 不能大于 后面的日期 且 前面日期都不能大于 2020-4-3减去3月零2天 后面日期 不能大于 2020-4-3
住店日期从  到  
<input type="text" class="Wdate" id="d4331" onFocus="WdatePicker({maxDate: '#F{$dp.$D(\'d4332\',{M:-3,d:-2})||$dp.$DV(\'2020-4-3\',{M:-3,d:-2})} '})"/>
<input type="text" class="Wdate" id="d4332" onFocus="WdatePicker({minDate: '#F{$dp.$D(\'d4331\',{M:3,d:2});} ',maxDate: '2020-4-3 '})"/>

注意:
#F{$dp.$D(\'d4332\',{M:-3,d:-2}) || $dp.$DV(\'2020-4-3\',{M:-3,d:-2})}
表示当 d4332 为空时, 采用 $dp.$DV(\'2020-4-3\',{M:-3,d:-2})} 的值作为最大值

使用 $dp.$DV 函数 可以将显式传入的值,加上定义的日期差量:
两个参数: value={字符类型}需要处理的值 , obj={对象类型}日期差量 
用法同上面的 $dp.$D 类似,如 $dp.$DV(\'2020-4-3\',{M:-3,d:-2}) 表示 2020-4-3减去3月零2天

示例4-3-4 发挥你的JS才能,定义任何你想要的日期限制
自动转到随机生成的一天,当然,此示例没有实际的用途,只是为演示目的
 
<script>
//返回一个随机的日期
function randomDate(){
var Y = 2000 + Math.round(Math.random() * 10);
var M = 1 + Math.round(Math.random() * 11);
var D = 1 + Math.round(Math.random() * 27);
return Y+'-'+M+'-'+D;
}
</script>
<input type="text" class="Wdate" id="d434" onFocus="var date=randomDate();WdatePicker({minDate:date,maxDate:date}) "/>

无效天 
可以使用此功能禁用周日至周六所对应的日期,相关属性:disabledDays (0至6 分别代表 周日至周六)

示例4-4-1 禁用 周六 所对应的日期
 
<input id="d441" type="text" class="Wdate" onFocus="WdatePicker({disabledDays: [6] })"/>

示例4-4-2 通过position属性,自定义弹出位置
 
<input id="d442" type="text" class="Wdate" onFocus="WdatePicker({disabledDays: [0,6] })"/>

无效日期 
注意:日期格式必须与 realDateFmt 和 realTimeFmt 一致 
可以使用此功能禁用,所指定的一个或多个日期,只要你熟悉正则表达式,你可以尽情发挥

用法(正则匹配): 
如果你熟悉正则表达式,会很容易理解下面的匹配用法
如果不熟悉,可以参考下面的常用示例 
['2008-02-01','2008-02-29'] 表示禁用 2008-02-01 和 2008-02-29
['2008-..-01','2008-02-29'] 表示禁用 2008-所有月份-01 和 2008-02-29
['200[0-8]]-02-01','2008-02-29'] 表示禁用 [2000至2008]-02-01 和 2008-02-29
['^2006'] 表示禁用 2006年的所有日期

此外,您还可以使用 %y %M %d %H %m %s 等变量, 用法同动态日期限制 注意:%ld不能使用 
['....-..-01','%y-%M-%d'] 表示禁用 所有年份和所有月份的第一天和今天 
['%y-%M-#{%d-1}','%y-%M-#{%d+1}'] 表示禁用 昨天和明天

当然,除了可以限制日期以外,您还可以限制时间
['....-..-.. 10\:00\:00'] 表示禁用 每天10点 (注意 : 需要 使用 \: )

不再多举例了,尽情发挥你的正则才能吧!

示例4-5-1 禁用 每个月份的 5日 15日 25日
 
<input id="d451" type="text" class="Wdate" onFocus="WdatePicker({disabledDates: ['5$'] })"/>

注意 : '5$' 表示以 5 结尾 注意 $ 的用法

示例4-5-2 禁用 所有早于2000-01-01的日期
 
<input id="d452" type="text" class="Wdate" onFocus="WdatePicker({disabledDates: ['^19'] })"/>

注意: '^19' 表示以 19 开头 注意 ^ 的用法 
当然,可以使用minDate实现类似的功能 这里主要是 在演示 ^ 的用法

示例4-5-3 配合min/maxDate使用,可以把可选择的日期分隔成多段
本示例本月可用日期分隔成五段 分别是: 1-3 8-10 16-24 26,27 29-月末
 
<input id="d453" type="text" class="Wdate" onFocus="WdatePicker({minDate: '%y-%M-01' ,maxDate: '%y-%M-%ld' ,disabledDates: ['0[4-7]$','1[1-5]$','2[58]$'] })"/>

示例4-5-4 min/maxDate disabledDays disabledDates 配合使用 即使在要求非常苛刻的情况下也能满足需求
 
<input id="d454" type="text" class="Wdate" onFocus="WdatePicker({minDate: '%y-%M-01' ,maxDate: '%y-%M-%ld' ,disabledDates: ['0[4-7]$','1[1-5]$','2[58]$'] ,disabledDays: [1,3,6] })"/>

示例4-5-5 禁用前一个小时和后一个小时内所有时间 使用 %y %M %d %H %m %s 等变量
鼠标点击 小时输入框时,你会发现当然时间对应的前一个小时和后一个小时是灰色的
 
<input id="d2a25" type="text" class="Wdate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',disabledDates: ['%y-%M-%d #{%H-1}\:..\:..','%y-%M-%d #{%H+1}\:..\:..'] })"/>

注意: %y %M %d等详见动态变量表

示例4-5-6 #F{}也是可以使用的
本示例利用自定义函数 随机禁用0-23中的任何一个小时
打开小时选择框,你会发现有一个小时被禁用的,而且每次禁用的小时都不同
 
<script>
function randomH(){
//产生一个随机的数字 0-23 
var H = Math.round(Math.random() * 23);
if(H<10) H='0'+H;
//返回 '^' + 数字
return '^'+H;
}
</script>
<input type="text" class="Wdate" id="d456" onFocus="WdatePicker({dateFmt:'HH:mm:ss',disabledDates: ['#F{randomH()}'] })"/>

有效天与有效日期 
使用无效天和无效日期可以很方便的禁用不可用的日期,但是在只需要启用少部分日期的情况下,有效天和有效日期的功能就非常适合了.
关键属性: opposite 默认为false, 为true时,无效天和无效日期变成有效天和有效日期

示例4-6 只启用 每个月份的 5日 15日 25日
 
<input id="d46" type="text" class="Wdate" onFocus="WdatePicker({opposite: true ,disabledDates: ['5$'] })"/>

注意 : '5$' 表示以 5 结尾 注意 $ 的用法

特殊天和特殊日期 
特殊天和特殊日期的用法跟完全无效天和无效日期完全相同,但是opposite属性对其无效

关键属性: 
specialDays (0至6 分别代表 周日至周六) 用法同无效天 
specialDates 用法同无效日期,但是对时分秒无效

示例4-7-1 高亮每周 周一 周五
 
<input id="d471" type="text" class="Wdate" onFocus="WdatePicker({specialDays: [1,5] })"/>

示例4-7-2 高亮每月 1号 15号
 
<input id="d472" type="text" class="Wdate" onFocus="WdatePicker({specialDates: ['....-..-01','....-..-15'] })"/>