package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/feign/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO){
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        return payFeignApi.addPay(payDTO);
    }
    @GetMapping("/feign/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData info=null;
        try {
            System.out.println("开始调用 ："+ DateUtil.now());
             info = payFeignApi.getInfo(id);

        }catch (Exception e){

            e.printStackTrace();
            System.out.println("结束调用： "+DateUtil.now());
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());


        }

        return info;
    }

    @GetMapping("/feign/pay/mylb")
    public String mylb(){
        return payFeignApi.mylb();
    }



}
