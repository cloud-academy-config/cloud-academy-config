package com.cloudlab.mvpuserservice.service;

import com.cloudlab.mvpuserservice.client.OrderClientService;
import com.cloudlab.mvpuserservice.data.dto.UserDto;
import com.cloudlab.mvpuserservice.data.entity.UserEntity;
import com.cloudlab.mvpuserservice.data.repository.UserRepository;
import com.cloudlab.mvpuserservice.data.vo.ResponseOrder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    //TODO Should handle bean problem
    //BCryptPasswordEncoder bCryptPasswordEncoder;

    Environment env;
    RestTemplate restTemplate;

    OrderClientService orderClientService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           //BCryptPasswordEncoder bCryptPasswordEncoder,
                           Environment env,
                           //RestTemplate restTemplate,
                           OrderClientService orderClientService) {
        this.userRepository = userRepository;
        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.env = env;
        //this.restTemplate = restTemplate;
        this.orderClientService = orderClientService;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        //TODO Should resolve bean not found issue
        //userEntity.setEncryptedPwd(bCryptPasswordEncoder.encode(userDto.getPwd()));

        userRepository.save(userEntity);
        UserDto returnUserDto = mapper.map(userEntity, UserDto.class);

        return returnUserDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);

        // Using Rest template
//        String orderUrl = String.format("http://user-service:8080/order-service/%s/orders", userId);
//        ResponseEntity<List<ResponseOrder>> orderListResponse =
//                restTemplate.exchange(orderUrl, HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<ResponseOrder>>() {
//        });

        //List<ResponseOrder> orderList = orderListResponse.getBody();

        // Using Open Feign
//        List<ResponseOrder> orderList = null;
//        try {
//            orderList = orderClientService.getOrders(userId);
//        } catch (FeignException e) {
//            log.error(e.getMessage());
//        }

        List<ResponseOrder> orderList = orderClientService.getOrders(userId);
        userDto.setOrders(orderList);
        return userDto;
    }

    @Override
    public Iterable<UserEntity> getUserByAll() {
        return userRepository.findAll();
    }
}
