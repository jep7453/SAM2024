package com.command;

import com.model.User;
import java.util.UUID;

public abstract class Command {

    public User actor;
    public Object subject;

    public abstract String execute();

    public User getActor(UUID userID) {
        return actor;
        
    }

    public Object getSubject(UUID id) {
        return id;

    }
} 