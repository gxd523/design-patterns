package com.gxd.design.patterns;

import com.gxd.design.patterns.builder.Person;
import com.gxd.design.patterns.decorator.ConcreteComponent;
import com.gxd.design.patterns.decorator.ConcreteDecorator1;
import com.gxd.design.patterns.decorator.ConcreteDecorator2;
import com.gxd.design.patterns.factory.Phone;
import com.gxd.design.patterns.factory.PhoneFactory;
import com.gxd.design.patterns.factory.phonefactoryimpl.OnePlusPhoneFactory;
import com.gxd.design.patterns.factory.phonefactoryimpl.SamsungPhoneFactory;
import com.gxd.design.patterns.observer.impl.Observable;
import com.gxd.design.patterns.observer.impl.Subscriber;
import com.gxd.design.patterns.proxy.Agent;
import com.gxd.design.patterns.proxy.Delegator;
import com.gxd.design.patterns.proxy.Subject;
import com.gxd.design.patterns.proxy.dynamic.ProxyHandler;
import com.gxd.design.patterns.singleton.HungrySingleton;
import com.gxd.design.patterns.singleton.LazySingleton;
import com.gxd.design.patterns.singleton.StaticSingleton;
import com.gxd.design.patterns.template.AbstractTemplate;
import com.gxd.design.patterns.template.ElephantTemplate;

import java.lang.reflect.Proxy;

/**
 * Created by guoxiaodong on 2019/4/5 12:17
 */
public class Main {
    public static void main(String[] args) {
        observerPattern();
        builderPattern();
        decoratorPattern();
        proxyPattern();
        dynamicProxyPattern();
        singletonPattern();
        factoryPattern();
        templatePattern();
    }

    /**
     * 单例模式
     */
    private static void singletonPattern() {
        // 饿汉式单例
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        // 懒汉式单例
        LazySingleton lazySingleton = LazySingleton.getInstance();
        // 静态单例
        StaticSingleton staticSingleton = StaticSingleton.getInstance();
    }

    /**
     * 模板模式
     */
    private static void templatePattern() {
        AbstractTemplate elephantTemplate = new ElephantTemplate();
        elephantTemplate.startWork();
    }

    /**
     * 动态代理模式
     */
    private static void dynamicProxyPattern() {
        Subject delegator1 = new Delegator();
        ProxyHandler proxyHandler = new ProxyHandler(delegator1);
        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[]{Subject.class},// 代理类实现的接口列表
                proxyHandler
        );
        proxySubject.doSomething();
    }

    /**
     * 代理模式
     */
    private static void proxyPattern() {
        Subject delegator = new Delegator();
        Subject agent = new Agent(delegator);
        agent.doSomething();
    }

    /**
     * 装饰模式
     */
    private static void decoratorPattern() {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecorator1 concreteDecorator1 = new ConcreteDecorator1(concreteComponent);
        concreteDecorator1.operate();
        ConcreteDecorator2 concreteDecorator2 = new ConcreteDecorator2(concreteComponent);
        concreteDecorator2.operate();
    }

    /**
     * 工厂模式
     */
    private static void factoryPattern() {
        Phone phone;
        PhoneFactory phoneFactory;

        phoneFactory = new OnePlusPhoneFactory();
        phone = phoneFactory.createPhone();
        phone.call();
        phone.sendMessage();

        phoneFactory = new SamsungPhoneFactory();
        phone = phoneFactory.createPhone();
        phone.call();
        phone.sendMessage();
    }

    /**
     * 建造者模式
     */
    private static void builderPattern() {
        Person person = new Person.PersonBuilder()
                .setName("Tom")
                .setAge(22)
                .build();
        System.out.println(person.toString());
    }

    /**
     * 观察者模式
     */
    private static void observerPattern() {
        Observable observable = new Observable();
        Subscriber subscriber1 = new Subscriber();
        observable.addObserver(subscriber1);
        Subscriber subscriber2 = new Subscriber();
        observable.addObserver(subscriber2);

        observable.notifyAllObservers("notify all subscriber.");
        observable.notify(subscriber1, "notify subscriber1.");
    }
}
