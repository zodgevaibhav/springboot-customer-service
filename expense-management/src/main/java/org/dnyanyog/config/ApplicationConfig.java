package org.dnyanyog.config;

import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;

@Configuration
@EncryptablePropertySource("encryptedv2.properties")
public class ApplicationConfig {

}
