package com.example.Splitwise.CommandLine;

import com.example.Splitwise.Controller.UserController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Getter@Setter
public class CommandsExecuter {
    //singleton pattern used

    private  static  CommandsExecuter instance;
    @Autowired
    private UserController userController;
    List<Commands> commandsList =new ArrayList<>();

    public void AddCommand(Commands command){
        if(!commandsList.contains(command)){    //check command is prensent
        commandsList.add(command);}  //Add command
    }
    public static synchronized CommandsExecuter getInstance(){
        if(instance== null){
            instance=new CommandsExecuter();

        }
        return  instance;
    }

    public void RemoveCommand(Commands command){
        if(commandsList.contains(command)==false){
            System.out.println("This commands is not friend");//remove command
        }else{
            commandsList.remove(command);
        }
    }

    public void Execute(String string) throws Exception {
        for(Commands c : commandsList){
            if (c.Matches(string)){
                c.execute(string);
                break;//execute the command
            }else{
                throw new Exception("command not found");
            }
        }
    }
}
