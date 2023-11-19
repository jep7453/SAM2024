package com.command;

import com.model.Root;
import com.model.User;
import java.util.UUID;

public abstract class Command {

    Root root = Root.getInstance();
    public User actor;

    public abstract String execute(UUID userID, UUID subjectID);

    public void setActor(UUID userID) {
        actor = (User) root.getSubject(userID);  
    }

    public abstract Object getSubject(UUID id);

    public abstract boolean checkPermissions();
} 