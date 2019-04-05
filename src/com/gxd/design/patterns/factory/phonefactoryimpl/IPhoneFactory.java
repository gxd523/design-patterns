package com.gxd.design.patterns.factory.phonefactoryimpl;

import com.gxd.design.patterns.factory.Phone;
import com.gxd.design.patterns.factory.PhoneFactory;
import com.gxd.design.patterns.factory.phoneimpl.IPhone;

/**
 * Created by guoxiaodong on 2019/4/5 14:26
 */
public class IPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
