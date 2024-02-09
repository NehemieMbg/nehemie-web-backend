package org.hyperskill.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import java.awt.image.BufferedImage;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
    
    @Bean
    public HttpMessageConverter<BufferedImage> bufferedImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
    
    @Bean
    public BytesEncryptor aesByteEncryptor() {
        String password = "hackme";
        String salt = "8560B4F4B3";
        return Encryptors.standard(password, salt);
    }

    @Bean
    public TextEncryptor hexEncodingTextEncryptor() {
        String password = "hackme"; // should be kept in a secure place and not be shared
        String salt = "8560b4f4b3"; // should be hex-encoded with even number of chars
        return Encryptors.text(password, salt);
    }
    
//    @Override
//    public void run(String... args) throws Exception {
//        BytesEncryptor bytesEncryptor = aesByteEncryptor();
//
//        byte[] inputData = {104, 121, 112, 101, 114, 115, 107, 105, 108, 108};
//        byte[] encryptedData = bytesEncryptor.encrypt(inputData);
//        byte[] decryptedData = bytesEncryptor.decrypt(encryptedData);
//
//        System.out.println("Input data: " + new String(inputData));
//        System.out.println("Encrypted data: " + new String(encryptedData));
//        System.out.println("Decrypted data: " + new String(decryptedData));
//    }
}
