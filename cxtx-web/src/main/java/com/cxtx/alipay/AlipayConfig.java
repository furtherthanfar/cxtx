package com.cxtx.alipay;

import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Timestamp;

@Configuration
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2021000117657021";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHGsJNlxuZ0PO92Fi31WYetPTlt7z4CWyqMh7taUHkzGHLi839u6nESlROMHr+ed5ev29RByY/ZecaY4DG3WHAunkoviLBeE/m2jWKwum5d17r2ak1E026LSgsP4ps0rREA5jWjucw6fV1uNp8qqo8ZuMIGo5H1bS5OFrLhttLe6QsH+1bDFCBQYDlzCwpGo1ZZDBI3b3zBUfitNLkZR5JuL/Mwh6mv88j3QqKg1Zv2cORCSGpXAcsJ52DAvt7N6piSA1HZlRUWUadbblufSyUPtnr54Xe2wPCRfOGHCYBoEJHw7l6alPLSvHkPSl5M1DbMW+kXpfcG6y3DlQdw2MZAgMBAAECggEAcWL501iQZ4VAKwJZYt+MNxUzu197DsgKFMS/xAxkqvsE0Gli1iIblouzOXPipZPuFqKfb+eKKAcD79e2ii/eDHvzl0gLr0ej92EHMo/mzCrs1Q/1vH+Y6jlfz9L7/9zOQY6rRNbmHN0djlE3vQ0Wll7bB0ASTSOD6zbqrIlfnnbJWXVX4+/4kzJ1TKlIflS14eLw3bd7QEeWhxnXb2MqBtE5Sd54vqAMsPckpWvOZ9ubaOXFRW1VyyRCsj4Y7BSfiaKwbWznZNKxVSdW9C1FOCGPHNutxg5IjAlNF0FA/5m0NWypsiS51mHeeu/KZmI/wbuAwBWzuOkcIS9UrFOsAQKBgQDTTekGPYG+SNJOdxVE7rq58WDQbUqpXKPfALi9I95yXE2148urZc3YWGt4YgGiKFrnCaVLNSlHtCQyGq3x0ZXbDDZS4QO87yUDE89xAT/NxTATev/f5+PkYFI7MZJrLl7XNDp/v8XTQFH8tBN25EXtoNjk5iX1AzpJhVkzdFZn2QKBgQCjrqS9Yzotq9IjLfXHSp8uIGptmoq+nObr30+2Walb1cI+G8CbA/zeJlNkzakSXUmLWEqg+pX7nEVMYQ7v+pxsAre2UnoQcpb5HWRAbGahKhWaHF5QNrYd5EjaRtMZpkW6ps5Fyho64VvspfRe7rdskvDSVEt6Wex87BSgcdUNQQKBgCwonAox0GtzzH+ZY1iEi4FQcGsea/v44EY6YGEmndZIc/UPJgErxVjxIYSG9tBsnpKp8WFGOtpBS08tRCzFIAwnATNQ0vcpAxMhkLiNCkh2bRWlHtQsIfQYLRcxxOehSTCwOYl5Cl6bkoa9G1Q9YF/IvYsYjdYmVogG1h1qsqQBAoGAMHzNxGSemWTqzQ0SX8UVPn7PyEQdkbW9GmZ+oJATAWdjMS7bcZBO2igUUCo0SYJlBOhUwzc4Mt7qEGQ4HpLov35WmaX5DuJDIuy4A/WYuWlUGOEKd0ydymETy8VrR4/f3BkJxdbGymZz6riGmZCxuXIV8NiTu1zkF2V//r9504ECgYEAo6pA1XDflWzeeN88dbINj45Cz5elK/m/USXsD4IHU40XYqdCvRPlWELk4cP6KLjrEJxrG0uRElPJPpZPERDmKfpsJWfmbfypgprSyw6+EhfspFgRA1KnlwJ3kJy8eTqsNtNXzAJ2E8e9+4YftsOWZ1GWDQdjmzu/FULhsPAupls=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg5wlGhbdo54VVk06eTEqbT8cormfHd2PMLXlog8if+hBaCnVLXSWo+qQeDgIS6j1UMsI1X9Qi/2N9XCUZqdQYW2yaBJv4nSgHzVKgTBHosHEh85NHbFbBTE1kmxYSXb5pzGiVoPFYL6qabB1OF5f/ZJGu/ntOseHNReyC2DO7ws+ArIJODt4kB8UYUlfPm4oVy9BJY76pVkmDlIwHu31C/lBVChY+qFFLNb6mPp100hwYOWi0Dl18n6m3bp7oupp01WfWHnec5WR76nAdcueBEjOEhaRdvZHxAav0HNcue813xs5FBzUJLA22ZhbMVR/JHpmxvUhMDM7Pws5NNIXrQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://www.baidu.com";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://www.baidu.com";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 设置订单完成时间
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        java.util.Date date = new java.util.Date();
        Timestamp timeStamp = new Timestamp(date.getTime());

        try {
            System.out.println(timeStamp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

                }
            }

}
