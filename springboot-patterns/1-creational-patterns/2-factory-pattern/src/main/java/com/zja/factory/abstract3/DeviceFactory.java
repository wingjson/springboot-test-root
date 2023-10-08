/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2023-10-08 9:36
 * @Since:
 */
package com.zja.factory.abstract3;

/**
 * 设备的抽象工厂接口
 *
 * @author: zhengja
 * @since: 2023/10/08 9:36
 */
interface DeviceFactory {
    Screen createScreen();

    Processor createProcessor();
}
