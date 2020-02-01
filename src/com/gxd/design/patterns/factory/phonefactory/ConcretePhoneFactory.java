package com.gxd.design.patterns.factory.phonefactory;

import com.gxd.design.patterns.factory.phone.Phone;

public class ConcretePhoneFactory implements PhoneFactory {
    @Override
    public <T extends Phone> T createPhone(Class<T> phoneClass) {
        T concretePhone = null;
        try {
            concretePhone = phoneClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return concretePhone;
    }
}
