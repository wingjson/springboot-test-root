/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2023-10-09 16:59
 * @Since:
 */
package com.zja.visitor.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhengja
 * @since: 2023/10/09 16:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements DeviceElement {
    // 实现具体的手机类
    private String model;

    @Override
    public void accept(DeviceVisitor visitor) {
        visitor.visit(this);
    }
}