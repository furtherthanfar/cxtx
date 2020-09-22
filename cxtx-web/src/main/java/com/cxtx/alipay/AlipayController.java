package com.cxtx.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Api(tags="支付宝接口管理")
@Controller
public class AlipayController {


    @RequestMapping("/pay")
    @ApiOperation(value = "支付界面跳转")
    public void payController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, "json", AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号
        String order_no = new String(request.getParameter("order_no").getBytes("ISO-8859-1"), "UTF-8");
        //付款金额
        String order_amount = new String(request.getParameter("order_amount").getBytes("ISO-8859-1"), "UTF-8");
        //景点
        String site = new String(request.getParameter("site").getBytes("ISO-8859-1"), "UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + order_no + "\","
                + "\"total_amount\":\"" + order_amount + "\","
                + "\"subject\":\"" + site + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        response.getWriter().write(form);
        //直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }
}
