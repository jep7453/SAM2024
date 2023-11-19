package com.command;


import com.UserRole;
import com.model.Root;
import com.model.User;
import java.util.UUID;
import java.util.EnumSet;

public abstract class Command {
 
    protected Root root = Root.getInstance();

    public abstract String execute(UUID userID, UUID subjectID, Object... elements);

    public User getActor(UUID userID) {
        return (User) root.getSubject(userID);  
    }

    public abstract Object getSubject(UUID id);

    public abstract boolean checkPermissions(User actor);
} 