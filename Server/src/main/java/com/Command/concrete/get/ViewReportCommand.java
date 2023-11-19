package com.command.concrete.get;

import java.util.UUID;

import com.command.Command;

/**
 * ViewReportCommand
 * 
 * SUBMITTER
 *      When the user wishes to see a papers report the system calls this command to get it for them
 * 
 * Valid Actors : SUBMITTER
 * Subject : Submission
 * Return : String representation of report
 */

public class ViewReportCommand extends Command{

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
