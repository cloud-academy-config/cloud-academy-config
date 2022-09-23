package com.cloudlab.mvpuserservice.client;

import com.cloudlab.mvpuserservice.data.vo.ResponseOrder;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderClientService {
    List<ResponseOrder> getOrders(@PathVariable String userId);
}