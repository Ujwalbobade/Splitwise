package com.example.Splitwise.CommandLine;

import com.example.Splitwise.DTO.SettleUpGroupReqDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class SettleUpGroupCommand implements Commands{
    @Override
    public boolean Matches(String Input) {
        return Input.toLowerCase().contains("Settleupgroup");
    }

    @Override
    public void execute(String String) {
        List<String> input=List.of(String.split(" "));
        SettleUpGroupReqDTO settleUpGroupReqDTO= new SettleUpGroupReqDTO();
        settleUpGroupReqDTO.setGroupid(Long.valueOf(input.get(1)));
    }
}
