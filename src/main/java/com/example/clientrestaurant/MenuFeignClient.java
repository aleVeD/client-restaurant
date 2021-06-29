package com.example.clientrestaurant;

import com.example.clientrestaurant.dto.MenuDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "recipe")
public class MenuFeignClient {
    /*
    @RequestMapping(method = RequestMethod.GET, value = MenuClientService)
    ResponseEntity<MenuDto> getMenuById(Long id){

    }*/
}
