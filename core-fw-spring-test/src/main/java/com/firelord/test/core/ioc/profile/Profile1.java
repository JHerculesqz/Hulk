package com.firelord.test.core.ioc.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * STEP2.Implement IProfile using @Profile("prod")
 */
@Component
@Profile("prod")
public class Profile1 implements IProfile {
    @Override
    public void run() {
        System.out.println("prod");
    }
}
