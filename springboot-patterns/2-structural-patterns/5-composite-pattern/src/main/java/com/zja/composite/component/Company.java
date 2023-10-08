/**
 * @Company: 上海数慧系统技术有限公司
 * @Department: 数据中心
 * @Author: 郑家骜[ào]
 * @Email: zhengja@dist.com.cn
 * @Date: 2023-10-08 16:57
 * @Since:
 */
package com.zja.composite.component;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合节点 公司(Company)，它可以包含多个部门
 *
 * @author: zhengja
 * @since: 2023/10/08 16:57
 */
public class Company implements Component {
    private String name;
    private List<Component> children;

    public Company(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Company: " + name);
        for (Component component : children) {
            component.display();
        }
    }
}
