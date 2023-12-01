package com.command.concrete.get;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

import com.UserRole;
import com.command.Command;
import com.model.User;

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
 * Subject : Root
 * Return :
 */
public class GetUsersByRoleCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (!checkPermissions(actor)) {
            return "Actor current role not able to run command";
        }
        UserRole searchRole = UserRole.valueOf((String) elements[0]);
        List<User> users = root.getUsersByRole(searchRole);
        List<String> userIDs = new ArrayList<>();

        for (User user : users) {
            userIDs.add(user.getUserID().toString());
        }
        return userIDs.toString();
    }

    @Override
    public User getSubject(UUID id) {
        return null;
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.PCM, UserRole.PCC, UserRole.ADMIN);
        return validRoles.contains(actor.getCurrentRole());
    }
    
}
