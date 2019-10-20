package com.dist.dao;

import com.dist.entity.TaskTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**定时任务数据配置接口
 * @author zhengja@dist.com.cn
 * @data 2019/8/13 17:12
 */
public interface TaskTimeDao extends JpaRepository<TaskTimeEntity,Long>{

    TaskTimeEntity queryById(Long id);

    TaskTimeEntity queryByTaskKey(String taskKey);

    boolean deleteByTaskKey(String taskKey);

    List<TaskTimeEntity> findByInitStartFlag(String initStartFlag);

}
