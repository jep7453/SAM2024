package com.command.concrete.post;

import java.util.UUID;

import com.command.Command;

/**
 * CreateUserCommand 
 * 
 * ADMIN
 *      When the user creates a user the system calls this command so the object is created
 * 
 * Valid Actors : ADMIN
 * Subject : ROOT
 * Return : Success/Fail
 */
public class CreateUserCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }

    @Override
    public Object getSubject(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubject'");
    }

    @Override
    public boolean checkPermissions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkPermissions'");
    }

}