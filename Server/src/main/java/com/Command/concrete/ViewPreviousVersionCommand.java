package com.command.concrete;

import com.command.Command;
import com.model.Submission;

import java.util.UUID;

public class ViewPreviousVersionCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID) {
        setActor(userID);
        getSubject(subjectID);
        
        return null;
    }

    @Override
    public Submission getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }
    
}
