package com.cloudlab.mvpuserservice.data.dto;

import com.cloudlab.mvpuserservice.data.vo.ResponseOrder;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Data createdAt;
    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
