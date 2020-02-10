package cn.bsnmdpf.fcprt.headquarters9001.config;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author LicoLeung
 * @create 2020-02-09 18:24
 */
@Component
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092300577144";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCciQtvjtAV6XVNwcQI8eVWyY557M0GGXX2YM0uZ7/yjbx9eNDiPwDRSYzDI85FWqhsiQUQG5gXxnmWBQ20T0KEtPlKtqGeJH3OCS33UW+FZ48fm65hhR0EfjhBsY4kE8kftkJ18kvNQffBGX60fpw44fqyqHXpAov2A71kvdvAGZUpTLp7RTbyvHyZeFIUJPNvs+nSiH8kujCaTQD+bnCrTnlj0gZO9dOXwDYDg1tNLzDdDHqy/+MXkmSrd1eYtydssf6FHMJxRF3nwv21RabJCKj7SpPu3ULkJENLJdl4l0Jmprj75TjQICSWflTCFKu/90MwXQAoVQ6T002CIXcLAgMBAAECggEAP3DnepoVyZupmA785WcsPKVJoi6P1XYCMg1/etw/lg1NpEiP1/IS4b9+ViQv2Dnq4roRnDqixJgC9QMtT7OD0QcLtfUYwWAmwJdF0uNlYFrdTcEpxopNfWGuaSmN4x9Ftx2GCAlgIVsoD1HG4V4i8IbdtQTDbOFEWjufybGM22idI7CIxHfRXThv2hjnKIJD4wWzv/RAJ1mHHdBQ5pZmcZNCXfsKPkBrVTc0ifLMTf3BwGcZYYDJuVIBwaaEpL4kOqFc9aWRO4YSbEkGRddI75MvH/vtap/xhhbqUY4AgRGGBP56m7C9jZ+mdADPatJwt6L5DwE0+XhQxX/OF9+mEQKBgQD2Oewz009x540+gvRxBfou8rZD3GHxXiJMRRvh8HyDxtpGZ/5KcNSrYST4spNqt20U5nnozjcg3WC6SU760SqUzHrPmnFftwXIFd1PY6/CMTscPJAqkEcFH6kKbX2+lr3+hq8yMi+37hYnseuBlehoOrwgv/0jTTdX897iChPwswKBgQCiv7WvRXsijZTgZkr2kFYdxg/Y7nz88k47fNbX1rwMLZ7Kdv/OoWSUiltq85aP+UqPQPE4Ec/tZU7oNzn84vjKZ301bB/kranoMa/WLIVzzG+ZfqcpB3uq17SOSNvywfwMa969rQDLbk05IBFLDlCuaEB/DXSEfwBGqOS5HgjcSQKBgQCp8ly3gJgK9Fkm1lhFUmzVzqxCtm/bmq9tmR2fms82XR/3DHwVgT8ocsqD5S2esK/XhySJrRub0XCb41FiCNCtF12EwQKTn82bxouT6ig7jqNP3/VZi2+Zd7rC+cOasoy8itWNfdo1x1z/VOxJ6uAYYMHMkPb1UKxsRmSF+5K7xQKBgGKHJXsi2VUl2cewphl3cGs+CUIPv+Ny3iHthjPNcLL+u29fc6ao1reGu6mYJsKq7ZSkgGStg+/4sTislpKe5nfDB25cM0LCUGaeDhHfijt8vON0ZcbVHO1lAY5SVbY18l2iwIqcPirqcB3xaAbEd9veiY1hm/TK3mPow+++WybhAoGACb9Gw9DxWCvzJ+aKjuEIApaOIuMD+5tdTt1v3DZDegzw5WJS2zvtLo56X8gvjNl9V/Nq9hv3UFf18TsjFuRWyh1meWmM9DzQEvSyOD9Dk5SVcDHuJtVKs9mW3L3R7qX3EAR1HdAaBk2cJKNBZuLnoJ5pOL7KHZYqTPIPzBGBl+k=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA/sguqrhWVBN/BeLkz2oFkJfFJw9dQPpiAjamufHfnM31vsaE9c0AeSg5FGq4j15bWhv9GLUpfJwDqQ++LfcW0OcnXJEAJmWDrh3tLTt49HHszX+x9/EqA+5j69QkjgLXTlmdQnP+RJuqyT9PvoeqegxS5gg9lv24mTiDhKx9FkYPJFf1D6fVz2hsHAXnRpxHO1YiWhE2dSdeRuV3OfKxf+t0BaMJGxLd7cId9WhR4DUrFQnK49xp7hvU2ShZk61JhHYY/RIObXTvn5yUUovtRFBEIGs1LqXPOea/P6nZpzvzwqYKrbF9sUAm6yi/MtemdwlJ+JXNwUNqMoB9DWSVrQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:9001/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:9001/return_url";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
