package com.cloudlab.mvpuserservice.provider.rest.client;

import com.cloudlab.mvpuserservice.client.OrderClientService;
import com.cloudlab.mvpuserservice.data.vo.ResponseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-service", url = "order-service")
public interface OrderFeignClientService extends OrderClientService {
    @Override
    @GetMapping(value = "/order-service/{userId}/orders")
    List<ResponseOrder> getOrders(@PathVariable String userId);
}
