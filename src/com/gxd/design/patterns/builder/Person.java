package com.gxd.design.patterns.builder;

/**
 * Created by guoxiaodong on 2019/4/5 12:13
 */
public class Person {
    private String name;
    private int age;
    private String sex;

    private Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.age = personBuilder.age;
        this.sex = personBuilder.sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ",age=" + age + ",sex=" + sex + "}";
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private String sex;

        public PersonBuilder() {
            this.name = "郭晓东";
            this.age = 28;
            this.sex = "男";
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
