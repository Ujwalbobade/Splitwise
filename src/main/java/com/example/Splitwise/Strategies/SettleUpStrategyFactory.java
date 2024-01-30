package com.example.Splitwise.Strategies;

import com.example.Splitwise.Models.settleUpStrategy;
import org.springframework.stereotype.Component;

@Component
public class SettleUpStrategyFactory {
    public static  SettleUpStrategy selectsettlupStrategy(settleUpStrategy settleUpStrategy){
        switch (settleUpStrategy){
            case HEAP_STRATEGY -> {
                return new HeapSettleUpStrategy();
            } default -> {
                return new HeapSettleUpStrategy();
            }
        }
    }
}
