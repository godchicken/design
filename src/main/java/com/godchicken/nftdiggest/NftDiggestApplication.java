package com.godchicken.nftdiggest;

import org.bouncycastle.openpgp.PGPPublicKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class NftDiggestApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(NftDiggestApplication.class, args);
//    }


    public static void main(String[] args) throws  Exception{
        PgpUtils pgpUtils = PgpUtils.getInstance();

        decryptFile();
    }

    public  static  void addSigunature(){
        byte[] sign= PgpUtils.signatureCreate("/Users/bijia/temp/origin_file.txt",
                "/Users/bijia/temp/self_gen/private-key.txt",
                "/Users/bijia/temp/20191014_sign_file.txt",
                "12345678");
        System.out.println(new String(sign));
    }

    public  static  void verifySigunature(){
        boolean flag = PgpUtils.verifySignature("/Users/bijia/temp/origin_file.txt",
                "/Users/bijia/temp/self_gen/public-key.txt",
                "/Users/bijia/temp/20191014_sign_file.txt");
        System.out.println(flag);
    }


    public  static  void encryptFile()  throws  Exception{
        PgpUtils pgpUtils = PgpUtils.getInstance();
        PGPPublicKey pgpPublicKey = pgpUtils.readPublicKey(new FileInputStream("/Users/bijia/temp/self_gen/public-key.txt"));
        OutputStream os = new FileOutputStream(new File("/Users/bijia/temp/20191014encrypt_file.txt"));
        pgpUtils.encryptFile(os,"/Users/bijia/temp/origin_file.txt",pgpPublicKey,false,false);

    }

    public  static  void decryptFile()  throws  Exception{
        PgpUtils pgpUtils = PgpUtils.getInstance();
        pgpUtils.decryptFile(new FileInputStream(new File("C:\\Users\\xiaodeng\\Desktop\\1.txt")),
                new FileOutputStream(new File("C:\\Users\\xiaodeng\\Desktop\\2.txt")),
                new FileInputStream(new File("C:\\Users\\xiaodeng\\Desktop\\3.txt")),
                "0x00FF33802cB62bF8fa7Ee8c5BA61E6d8F5477382".toCharArray());
    }
}
