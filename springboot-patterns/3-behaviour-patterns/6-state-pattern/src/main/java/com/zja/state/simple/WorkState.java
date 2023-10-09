/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2023-10-09 14:55
 * @Since:
 */
package com.zja.state.simple;

/**
 * @author: zhengja
 * @since: 2023/10/09 14:55
 */
// Concrete State - 工作状态
class WorkState implements State {
    @Override
    public void handle() {
        System.out.println("当前处于工作状态");
    }
}