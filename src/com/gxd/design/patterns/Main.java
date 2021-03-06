package com.gxd.design.patterns;

import com.gxd.design.patterns.adapter.Adapter;
import com.gxd.design.patterns.adapter.Target;
import com.gxd.design.patterns.builder.Person;
import com.gxd.design.patterns.chain.event.Event;
import com.gxd.design.patterns.chain.event.impl.Activity;
import com.gxd.design.patterns.chain.event.impl.View;
import com.gxd.design.patterns.chain.event.impl.ViewGroup;
import com.gxd.design.patterns.chain.interceptor.Interceptor;
import com.gxd.design.patterns.chain.interceptor.Request;
import com.gxd.design.patterns.chain.interceptor.impl.CallServerInterceptor;
import com.gxd.design.patterns.chain.interceptor.impl.ChainImpl;
import com.gxd.design.patterns.chain.interceptor.impl.RetryAndFollowUpInterceptor;
import com.gxd.design.patterns.decorator.ConcreteComponent;
import com.gxd.design.patterns.decorator.ConcreteDecorator1;
import com.gxd.design.patterns.decorator.ConcreteDecorator2;
import com.gxd.design.patterns.factory.phone.OnePlusPhone;
import com.gxd.design.patterns.factory.phone.Phone;
import com.gxd.design.patterns.factory.phone.SamsungPhone;
import com.gxd.design.patterns.factory.phonefactory.ConcretePhoneFactory;
import com.gxd.design.patterns.factory.phonefactory.PhoneFactory;
import com.gxd.design.patterns.observer.Observable;
import com.gxd.design.patterns.observer.Observer;
import com.gxd.design.patterns.observer.callback.Button;
import com.gxd.design.patterns.observer.callback.OnClickListener;
import com.gxd.design.patterns.proxy.Subject;
import com.gxd.design.patterns.proxy.SubjectImpl;
import com.gxd.design.patterns.proxy.SubjectProxy;
import com.gxd.design.patterns.singleton.EnumSingleton;
import com.gxd.design.patterns.singleton.HungrySingleton;
import com.gxd.design.patterns.singleton.LazySingleton;
import com.gxd.design.patterns.singleton.StaticSingleton;
import com.gxd.design.patterns.state.CloseState;
import com.gxd.design.patterns.state.Context;
import com.gxd.design.patterns.template.AbstractTemplate;
import com.gxd.design.patterns.template.ElephantTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoxiaodong on 2019/4/5 12:17
 */
public class Main {
    public static void main(String[] args) {
        callback();
        observerPattern();
        builderPattern();
        decoratorPattern();
        proxyPattern();
        dynamicProxyPattern();
        singletonPattern();
        factoryPattern();
        templatePattern();
        responsibilityChainPattern();
        okHttpInterceptor();
        adapterPattern();
        statePattern();
    }

    private static void statePattern() {
        Context context = new Context();
        context.setCurrentState(new CloseState());

        context.open();

        context.run();
        
        context.close();
        context.run();
        context.stop();
        context.open();
    }

    private static void adapterPattern() {
        Target adapter = new Adapter();
        System.out.println(adapter.getFive());
    }

    private static void okHttpInterceptor() {
        List<Interceptor> interceptorList = new ArrayList<>();
        interceptorList.add(new RetryAndFollowUpInterceptor());
        interceptorList.add(new CallServerInterceptor());
        Request originalRequest = new Request() {
        };
        ChainImpl chain = new ChainImpl(interceptorList, 0, originalRequest);
        chain.process(originalRequest);
    }

    /**
     * 责任链模式
     */
    private static void responsibilityChainPattern() {
        Activity activity = new Activity();
        ViewGroup viewGroup = new ViewGroup();
        View view = new View();

        activity.setNextHandler(viewGroup);
        viewGroup.setNextHandler(view);

        Event event = new Event();
        activity.dispatchEvent(event);
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
        // 枚举单例
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
    }

    /**
     * 模板模式
     */
    private static void templatePattern() {
        AbstractTemplate elephantTemplate = new ElephantTemplate();
        elephantTemplate.startWork();
    }

    /**
     * 代理模式
     */
    private static void proxyPattern() {
        Subject subject = new SubjectImpl();

        Subject subjectProxy = new SubjectProxy(subject);

        subjectProxy.doSomething();
    }

    /**
     * 动态代理模式
     */
    private static void dynamicProxyPattern() {
        Subject subject = new SubjectImpl();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("do something before.");
                Object result = method.invoke(subject, args);
                System.out.println("do something after.");
                return result;
            }
        };
        Subject subjectProxy = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[]{Subject.class},// 代理类实现的接口列表
                invocationHandler
        );

//        Subject subjectProxy = new $Proxy0(invocationHandler);

        subjectProxy.doSomething();
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

        phoneFactory = new ConcretePhoneFactory();
        phone = phoneFactory.createPhone(SamsungPhone.class);
        phone.call();
        phone.sendMessage();

        phone = phoneFactory.createPhone(OnePlusPhone.class);
        phone.call();
        phone.sendMessage();
    }

    /**
     * 建造者模式
     */
    private static void builderPattern() {
        Person person = new Person.Builder()
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
        Observer observer1 = data -> System.out.println("observer1..." + data.toString());
        observable.addObserver(observer1);
        Observer observer2 = data -> System.out.println("observer2..." + data.toString());
        observable.addObserver(observer2);

        observable.notifyAllObservers("notify all observer.");
        observable.notify(observer1, "notify observer1.");
    }

    /**
     * 回调
     */
    private static void callback() {
        Button button = new Button();
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("onClick");
            }
        });

        button.click();
    }
}
