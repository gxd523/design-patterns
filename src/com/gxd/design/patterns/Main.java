package com.gxd.design.patterns;

import com.gxd.design.patterns.builder.Person;
import com.gxd.design.patterns.factory.Phone;
import com.gxd.design.patterns.factory.PhoneFactory;
import com.gxd.design.patterns.factory.phonefactoryimpl.IPhoneFactory;
import com.gxd.design.patterns.factory.phonefactoryimpl.SamsungPhoneFactory;
import com.gxd.design.patterns.observer.impl.Observable;
import com.gxd.design.patterns.observer.impl.Subscriber;

/**
 * Created by guoxiaodong on 2019/4/5 12:17
 */
public class Main {
    public static void main(String[] args) {
        // 建造者设计模式
        Person person = new Person.PersonBuilder()
                .setName("Tom")
                .setAge(22)
                .build();
        System.out.println(person.toString());
        // 工厂设计模式
        Phone phone;
        PhoneFactory phoneFactory;

        phoneFactory = new IPhoneFactory();
        phone = phoneFactory.createPhone();
        phone.call();
        phone.sendMessage();

        phoneFactory = new SamsungPhoneFactory();
        phone = phoneFactory.createPhone();
        phone.call();
        phone.sendMessage();
        // 观察者模式
        Observable observable = new Observable();
        Subscriber subscriber1 = new Subscriber();
        observable.addObserver(subscriber1);
        Subscriber subscriber2 = new Subscriber();
        observable.addObserver(subscriber2);

        observable.notifyAllObservers("notify all subscriber.");
        observable.notify(subscriber1, "notify subscriber1.");
    }
}
