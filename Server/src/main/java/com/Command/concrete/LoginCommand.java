package com.command.concrete;

import com.command.Command;
import com.model.User;

import java.util.UUID;

public class LoginCommand extends Command {

    @Override
    public String execute(UUID userID, UUID subjectID) {
        setActor(userID);
        getSubject(subjectID);
        // subjectID.login()
        return null;
    }

    @Override
    public User getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
    
}
