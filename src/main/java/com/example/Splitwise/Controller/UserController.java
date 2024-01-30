package com.example.Splitwise.Controller;

import com.example.Splitwise.DTO.ResponseStatus;
import com.example.Splitwise.DTO.UserReqDTO;
import com.example.Splitwise.DTO.UserResDTO;
import com.example.Splitwise.Models.User;
import com.example.Splitwise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    public UserResDTO Register(UserReqDTO userResDTO){
        UserResDTO response = new UserResDTO();
        try{
            System.out.println("service is running now");
            User newuser=userService.registerUser(userResDTO.getUsername(), userResDTO.getPhoneNO(), userResDTO.getPassword());
            response.setUserid(newuser.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

}
