package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.print.attribute.standard.PrinterURI;

@RestController
public class OrderController {

    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/pay/add")
    public ResultData<String> addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",payDTO,ResultData.class);
    }
    @GetMapping("/consumer/pay/del/{id}")
    public ResultData<String> delOrder(@PathVariable("id") Integer id){
       return restTemplate.getForObject(PaymentSrv_URL+"/pay/del/",ResultData.class,id);
    }
    @GetMapping("/consumer/pay/update")
    public ResultData<String> updateOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/update/",payDTO,ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData<String> getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ResultData.class, id);
    }


    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }


}
