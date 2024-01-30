package com.example.Splitwise.Controller;

import com.example.Splitwise.DTO.SettleUpGroupReqDTO;
import com.example.Splitwise.DTO.SettleUpGroupResDTO;
import com.example.Splitwise.DTO.SettleUpUserReqtDTO;
import com.example.Splitwise.DTO.SettleUpUserResDTO;
import com.example.Splitwise.Models.Expenses;
import com.example.Splitwise.Service.SettleUpService;
import com.example.Splitwise.Strategies.HeapSettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    @Autowired
    private SettleUpService settleUpService;

    private HeapSettleUpStrategy heapSettleUpStrategy;
    public SettleUpUserReqtDTO SettleUpUser(SettleUpUserReqtDTO settleUpUserReqtDTO){
        SettleUpUserResDTO settleUpUserResDTO = new SettleUpUserResDTO();
        try{
            List<Expenses> listExpense=settleUpService.settleUpUser(settleUpUserReqtDTO.getUserId());
            List<Expenses> finall=heapSettleUpStrategy.settleUp(listExpense);
            settleUpUserResDTO.setTransactions(finall);
        }catch (Exception e){
            e.getMessage();
        }
        return settleUpUserReqtDTO;
    }
    public SettleUpGroupResDTO SettleUpGroup(SettleUpGroupReqDTO settleUpGroupReqDTO){
        SettleUpGroupResDTO settleUpGroupResDTO = new SettleUpGroupResDTO();
        try {
            List<Expenses> listexpense=settleUpService.settleUpGroup(settleUpGroupReqDTO.getGroupid());
            List<Expenses> finall=heapSettleUpStrategy.settleUp(listexpense);
            settleUpGroupResDTO.setTransactions(finall);
            return settleUpGroupResDTO;
        }catch (Exception e){
            e.getMessage();
        }
    return null;
    }
}
