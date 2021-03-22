package com.graduationproject.campuslifecommon.constant;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-12 22:58
 **/
public class AESUtils {

        public static String aesEncode(String encodeRules, String content) {
            try {
                if (content == null) {
                    content = "";
                }
                // 1.构造密钥生成器，指定为AES算法,不区分大小写
                KeyGenerator keygen = KeyGenerator.getInstance("AES");
                // 2.根据ecnodeRules规则初始化密钥生成器
                // 生成一个128位的随机源,根据传入的字节数组
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed(encodeRules.getBytes());
                keygen.init(128, secureRandom);
                // keygen.init(128, new SecureRandom(encodeRules.getBytes()));
                // 3.产生原始对称密钥
                SecretKey original_key = keygen.generateKey();
                // 4.获得原始对称密钥的字节数组
                byte[] raw = original_key.getEncoded();
                // 5.根据字节数组生成AES密钥
                SecretKey key = new SecretKeySpec(raw, "AES");
                // 6.根据指定算法AES自成密码器
                Cipher cipher = Cipher.getInstance("AES");
                // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
                cipher.init(Cipher.ENCRYPT_MODE, key);
                // 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
                byte[] byte_encode = content.getBytes("utf-8");
                // 9.根据密码器的初始化方式--加密：将数据加密
                byte[] byte_AES = cipher.doFinal(byte_encode);
                // 10.将加密后的数据转换为字符串
                // 这里用Base64Encoder中会找不到包
                // 解决办法：
                // 在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
                String AES_encode = new String(Base64Utils.encode(byte_AES));

                // 11.将字符串返回
                return AES_encode;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            // 如果有错就返加nulll
            return null;
        }

        /**
         * 解密 解密过程： 1.同加密1-4步 2.将加密后的字符串反纺成byte[]数组 3.将加密内容解密
         */
        public static String aesDncode(String encodeRules, String content) {
            try {
                // 1.构造密钥生成器，指定为AES算法,不区分大小写
                KeyGenerator keygen = KeyGenerator.getInstance("AES");
                // 2.根据ecnodeRules规则初始化密钥生成器
                // 生成一个128位的随机源,根据传入的字节数组
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                secureRandom.setSeed(encodeRules.getBytes());
                keygen.init(128, secureRandom);
                // keygen.init(128, new SecureRandom(encodeRules.getBytes()));
                // 3.产生原始对称密钥
                SecretKey original_key = keygen.generateKey();
                // 4.获得原始对称密钥的字节数组
                byte[] raw = original_key.getEncoded();
                // 5.根据字节数组生成AES密钥
                SecretKey key = new SecretKeySpec(raw, "AES");
                // 6.根据指定算法AES自成密码器
                Cipher cipher = Cipher.getInstance("AES");
                // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
                cipher.init(Cipher.DECRYPT_MODE, key);
                // 8.将加密并编码后的内容解码成字节数组
                byte[] byte_content = Base64Utils.decodeFromString(content) ;
                /*
                 * 解密
                 */
                byte[] byte_decode = cipher.doFinal(byte_content);
                String AES_decode = new String(byte_decode, "utf-8");
                return AES_decode;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }
            // 如果有错就返加nulll
            return null;
        }

//    public static void main(String[] args) {
//
//        String  data = "<Request>" + "     <head>SF-SZFB-SZQ-JKDJLDCS</head>" + "	<body>" + "		<order>"
//                + "			<order_code>FS123456789</order_code>" + "			<sender_info>"
//                + "				<Name>寄方姓名</Name>" + "				<Tel>18888888888</Tel>"
//                + "				<Company>SF</Company>" + "				<Province>广东省</Province>"
//                + "				<City>深圳市</City>" + "				<County>福田区</County>"
//                + "				<Detail>天安数码城天吉大厦2L</Detail>" + "			</sender_info>" + "			<receive_info>"
//                + "				<Name>收方姓名</Name>" + "				<Tel>18888888888</Tel>"
//                + "				<Company>JD</Company>" + "				<Province>广东省</Province>"
//                + "				<City>深圳市</City>" + "				<County>黄贝岭</County>"
//                + "				<Detail>黄贝岭中村11栋604B</Detail>" + "			</receive_info>" + "		</order>"
//                + "	</body>" + "</Request>";
//
//        System.out.println(AESUtils.aesEncode("YXDJ2019_Interface", data));
//    }



}
