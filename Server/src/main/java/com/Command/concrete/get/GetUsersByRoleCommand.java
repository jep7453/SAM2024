package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;

/**
 * GetUsersByRoleCommand
 * 
 * ADMIN
 *      When the user manages other users the system calls this command to give the options
 * PCC
 *      When the user assigns reviews to PCMs the system calls this command to give the options
 * PCM
 *      When the user sets review preferences the system calls this command to give the options
 * 
 * Valid Actors : ADMIN/PCC/PCM
 * Subject :
 * Return :
 */
public class GetUsersByRoleCommand extends Command{

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
