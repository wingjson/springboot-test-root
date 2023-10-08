/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2023-10-08 10:00
 * @Since:
 */
package com.zja.abstract1.osui;

/**
 * 抽象工厂类来创建UI组件
 *
 * @author: zhengja
 * @since: 2023/10/08 10:00
 */
public interface UIFactory {
    Button createButton();

    TextBox createTextBox();
}
