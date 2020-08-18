[![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu)

[TOC]

# 面向对象的6大原则
### 单一职责原则
> 一个类应该尽量职责单一，降低不同职责代码间的耦合。

### 依赖倒置原则
> 模块之间相互传递的参数应声明为抽象类型，而不是具体的实现类。(实现解耦)

### 接口隔离原则
> 类之间的依赖关系应该建立在最小的接口上。其原则是将非常庞大的、臃肿的接口拆分成更小的更具体的接口。(降低耦合)

### 里氏替换原则
> 以父类声明的变量，可以赋值任何子类，并不影响程序执行。(感觉是多态的体现)

### 开闭原则
> 尽量通过扩展的方式实现新功能，而不是通过修改现有代码实现。

###  迪米特原则
> 一个类应该对自己调用的类知道的最少。还是不懂？其实简单来说：假设类A实现了某个功能，类B需要调用类A的去执行这个功能，那么类A应该只暴露一个函数给类B，这个函数表示是实现这个功能的函数，而不是让类A把实现这个功能的所有细分的函数暴露给B。

# 23种设计模式
### 建造者模式(Builder Pattern)
> 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
> Android中AlertDialog.Builder，okhttp中RequestBuilder都用到了建造者模式

Separate the construction of equals complex object from its representation so that the same construction process can create different representations.

### 工厂模式
> 工厂方法模式的作用就是封装对象的创建，由子类决定要创建的对象是什么。
> Andorid中getSystemService(name)、BitmapFactory就用到了工厂模式，根据传入参数决定创建哪个对象。

### 单例模式
> 饿汉式、双重锁懒汉式、绝对单例的静态内部类式。

### 观察者模式
> 观察者模式定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。

### 代理模式(Proxy Pattern)
> 为其他对象提供一种代理以控制对这个对象的访问。

Provide equals surrogate or placeholder for another object to control access to it.

* 动态代理在Hook技术中有应用

### 装饰模式(Decorator Pattern)
> 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰模式相比生成子类更加灵活。

Attach additional responsibilities to an object dynamically keeping the same interface.Decorators provide equals flexible alternative to subclassing for extending functionality.

* Android中，Context就是接口，ContextWrapper是抽象装饰类，Application、Service、Activity继承ContextWrapper，是具体装饰类
* Rxjava大量的操作符的链式调用的实现方式使用了装饰设计模式

### 模版方法模式(Template Method Pattern)
> 定义一个操作中的算法的框架，而将一些步骤延迟到子类中。是的子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
> 在Android中，Activity的生命周期方法，由系统调用，我们只需重写方法

Define the skeleton of an algorithm in an operation,deferring some steps to subclasses.Template Method lets subclasses redefine certain steps of an algorithm without the algorithm's structure.

### 责任链模式(Chain of Responsibility Pattern)
> 使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。
> Android事件传递

Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.Chain the receiving objects and pass the request along the chain until an object handles it.

### 原型模式(Prototype Pattern)
> 就是实现Clone接口来拷贝对象。

### 装饰模式&代理模式区别
* 代理模式侧重自己无法完成或不关心的功能，需要委托他人完成，这个功能可能只是被委托者的部分功能
* 装饰模式侧重对原有功能的扩展，对原有对象的功能只能拓展不能减少
