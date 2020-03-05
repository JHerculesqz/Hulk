package com.firelord.test.core.fw.spring.core.ioc.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * STEP2.Implement IProfile using @Profile("test")
 */
@Component
@Profile("test")
public class Profile2 implements IProfile {
    @Override
    public void run() {
        System.out.println("test");
    }
}
