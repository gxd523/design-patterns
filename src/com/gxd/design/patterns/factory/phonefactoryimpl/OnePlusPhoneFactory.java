package com.gxd.design.patterns.factory.phonefactoryimpl;

import com.gxd.design.patterns.factory.Phone;
import com.gxd.design.patterns.factory.PhoneFactory;
import com.gxd.design.patterns.factory.phoneimpl.OnePlusPhone;

/**
 * 一加手机工厂生产一加手机
 */
public class OnePlusPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new OnePlusPhone();
    }
}
