package com.cloudlab.mvpuserservice.data.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResponseUser {
    private String email;
    private String name;
    private String userId;

    private List<ResponseOrder> orders;
}
