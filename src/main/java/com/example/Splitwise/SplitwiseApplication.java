package com.example.Splitwise;

import com.example.Splitwise.CommandLine.Commands;
import com.example.Splitwise.CommandLine.CommandsExecuter;
import com.example.Splitwise.CommandLine.RegisterUserCommand;
import com.example.Splitwise.Controller.UserController;
import com.example.Splitwise.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;
@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner{
	@Autowired
	private CommandsExecuter commandsExecuter;
	@Autowired
	private RegisterUserCommand registerUserCommand;
	private static Logger LOG = LoggerFactory
			.getLogger(SplitwiseApplication.class);
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		LOG.info("\n Executing :commnadlinner");
		while(true){
			String input = sc.nextLine();
			commandsExecuter.AddCommand(registerUserCommand);
			LOG.info("Command is excuitnggs");
			commandsExecuter.Execute(input);
			//CommandsExecuter c=CommandsExecuter.getInstance();
			//c.AddCommand(new RegisterUserCommand(new UserController(new UserService())));

			//c.Execute(input);
		}}

	public static void main(String[] args) {
		LOG.info("\n Startting :springboot application");
		SpringApplication.run(SplitwiseApplication.class, args);
		LOG.info("\n Stopped :springboot application");
	}
}

