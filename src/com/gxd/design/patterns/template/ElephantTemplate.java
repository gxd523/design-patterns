package com.gxd.design.patterns.template;

/**
 * Created by guoxiaodong on 2019-05-05 15:42
 */
public class ElephantTemplate extends AbstractTemplate {
    @Override
    protected void firstStep() {
        System.out.println("第一步:打开冰箱门!");
    }

    @Override
    protected void secondStep() {
        System.out.println("第二步:把大象放进去!");
    }

    @Override
    protected void thirdStep() {
        System.out.println("第三步:关好冰箱门!");
    }
}
