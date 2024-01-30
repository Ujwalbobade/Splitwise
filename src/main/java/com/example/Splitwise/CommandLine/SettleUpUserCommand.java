package com.example.Splitwise.CommandLine;

import com.example.Splitwise.Controller.SettleUpController;
import com.example.Splitwise.DTO.SettleUpGroupReqDTO;
import com.example.Splitwise.DTO.SettleUpUserReqtDTO;
import com.example.Splitwise.DTO.SettleUpUserResDTO;

import java.util.Arrays;
import java.util.List;

public class SettleUpUserCommand implements Commands{
    private SettleUpController settleUpController;
    SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController=settleUpController;
    }

    @Override
    public boolean Matches(String Input) {
        return Input.toLowerCase().contains("settleupuser");
    }

    @Override
    public void execute(String String) {
        List<String> input= Arrays.stream(String.split(" ")).toList();
        SettleUpUserReqtDTO settleUpUserReqDTO= new SettleUpUserReqtDTO();
        settleUpUserReqDTO.setUserId(Long.valueOf(input.get(1)));
        settleUpController.SettleUpUser(settleUpUserReqDTO);

    }
}
