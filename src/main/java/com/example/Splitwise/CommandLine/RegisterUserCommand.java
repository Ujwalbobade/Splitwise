package com.example.Splitwise.CommandLine;

import com.example.Splitwise.CommandLine.Commands;
import com.example.Splitwise.Controller.UserController;
import com.example.Splitwise.DTO.ResponseStatus;
import com.example.Splitwise.DTO.UserReqDTO;
import com.example.Splitwise.DTO.UserResDTO;

import com.example.Splitwise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Commands {
    @Autowired
    UserController userController;
    public RegisterUserCommand(UserController userController){
        this.userController=userController;
    }


    @Override
    public boolean Matches(String Input) {
       /* if(Input=="Register"|| Input=="register"){
            return true;
        }else {
        return false;}*/
        return Input.toLowerCase().contains("register"); //check "resgister" in string
    }

    @Override
    public void execute(String String) {
        UserReqDTO userReqDTO=new UserReqDTO();
        List<String> ss= List.of(String.split(" "));
        userReqDTO.setPassword(ss.get(3));
        userReqDTO.setPhoneNO(ss.get(2));
        userReqDTO.setUsername(ss.get(1));
        /*System.out.println(ss.get(2));
        System.out.println(ss.get(1));*/
                                                            //create req DTo to pass register method in usercontrolle
        /*UserResDTO response=userController.Register(userReqDTO);
        response.setResponseStatus(ResponseStatus.SUCCESS);*/
        UserResDTO response = userController.Register(userReqDTO);
        response.setResponseStatus(ResponseStatus.SUCCESS);
    }
}
