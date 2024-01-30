package com.example.Splitwise.Service;

import com.example.Splitwise.Models.Expenses;
import com.example.Splitwise.Models.User;
import com.example.Splitwise.Models.UserExpense;
import com.example.Splitwise.Models.group;
import com.example.Splitwise.Repository.ExpenseUserRepository;
import com.example.Splitwise.Repository.ExpensesRepository;
import com.example.Splitwise.Repository.GroupRepository;
import com.example.Splitwise.Repository.UserRepository;
import com.example.Splitwise.Strategies.HeapSettleUpStrategy;
import com.example.Splitwise.Strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {
    private GroupRepository groupRepository;
    private ExpensesRepository expensesRepository;
    private SettleUpStrategy settleUpStrategy;

    private HeapSettleUpStrategy heapSettleUpStrategy;

    private UserRepository userRepository;

    private ExpenseUserRepository expenseUserRepository;
    @Autowired
    SettleUpService(GroupRepository groupRepository,
    ExpensesRepository expensesRepository,SettleUpStrategy settleUpStrategy,UserRepository userRepository,ExpenseUserRepository expenseUserRepository,HeapSettleUpStrategy heapSettleUpStrategy)
    {
        this.groupRepository=groupRepository;
        this.expensesRepository=expensesRepository;
        this.settleUpStrategy=settleUpStrategy;
        this.userRepository=userRepository;
        this.expenseUserRepository=expenseUserRepository;
        this.heapSettleUpStrategy=heapSettleUpStrategy;
    }
    public List<Expenses> settleUpUser(Long Userid) throws Exception {
            Optional<User> UserOptional= userRepository.findById(Userid);
            if(UserOptional.isEmpty()){
                throw  new Exception("User does not exist");
            }
            User user = UserOptional.get();

            List<UserExpense> allexpensebyuser=expenseUserRepository.findAllByUser(user);

            //to avoid dupliacte expense

            Set<Expenses> expenseSet=new HashSet<>();
            for(UserExpense expenseUSer : allexpensebyuser){
                expenseSet.add(expenseUSer.getExpenses());
            }
            List<Expenses> transactions = heapSettleUpStrategy.settleUp(expenseSet.stream().toList());


            return transactions;

        }
    public List<Expenses> settleUpGroup(Long Groupid){

        //1 Validate the group
        Optional<group> Groupoptional=groupRepository.findById(Groupid);
        if(Groupoptional.isEmpty()){
            throw new RuntimeException("Group Doesnt Exist");
        }
        group group=Groupoptional.get();

        //extract all the expense of the group
        List<Expenses> listofexpense=expensesRepository.findAllByGroup(group);

        List<Expenses> transactions = heapSettleUpStrategy.settleUp(listofexpense.stream().toList());

        //List<Expenses> transactions=settleUpStrategy.settleUp(listofexpense);
        return  transactions;

}

}
