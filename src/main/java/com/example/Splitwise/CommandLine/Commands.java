package com.example.Splitwise.CommandLine;

public interface Commands{
    boolean Matches(String Input);

    void execute(String String);
}
