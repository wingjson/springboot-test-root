package com.zja.controller;

import com.zja.task.AlarmTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengja@dist.com.cn
 * @data 2019/8/13 14:33
 */
@Api(tags = {"AlarmTaskController"},description = "Spring Task")
@RestController
@RequestMapping(value = "rest/alarmtask")
public class AlarmTaskController {

    @Autowired
    private AlarmTask alarmTask;

    @ApiOperation(value = "开启所有定时任务-支持多线程",httpMethod = "GET")
    @RequestMapping(value = "taskExecutor",method = RequestMethod.GET)
    public void alarmTask() throws Exception {
        alarmTask.run();
        alarmTask.run1();
        alarmTask.run2();
        alarmTask.run3();
    }

    @ApiOperation(value = "开启单个定时任务-多线程",httpMethod = "GET")
    @RequestMapping(value = "taskExecutor/run",method = RequestMethod.GET)
    public void alarmTask1() throws Exception {
        alarmTask.run();
    }

    @ApiOperation(value = "定时任务1-多线程",httpMethod = "GET")
    @RequestMapping(value = "taskExecutor/run1",method = RequestMethod.GET)
    public void alarmTask2() throws Exception {
        alarmTask.run1();
    }

    @ApiOperation(value = "定时任务2-多线程",httpMethod = "GET")
    @RequestMapping(value = "taskExecutor/run2",method = RequestMethod.GET)
    public void alarmTask3() throws Exception {
        alarmTask.run2();
    }

    @ApiOperation(value = "定时任务3-多线程",httpMethod = "GET")
    @RequestMapping(value = "taskExecutor/run3",method = RequestMethod.GET)
    public void alarmTask4() throws Exception {
        alarmTask.run3();
    }
}