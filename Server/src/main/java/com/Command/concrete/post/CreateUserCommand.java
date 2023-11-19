package com.command.concrete.post;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.UUID;
import java.util.stream.Collectors;

import com.UserRole;
import com.command.Command;
import com.model.Root;
import com.model.User;

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

/**
 * elements = username : String, password : String, name: String, EnumSet<UserRole> : roles
 * addUser()
 */
public class CreateUserCommand extends Command{

    @Override
    public String execute(UUID userID, UUID subjectID, Object... elements) {
        User actor = getActor(userID);
        if (checkPermissions(actor) == false) {
            return "Invalid Permissions";
        }
        Root subject = root;
        String elementRoles = (String) elements[3];
        EnumSet<UserRole> roles = Arrays.stream(elementRoles.split(","))
                .map(UserRole::valueOf)
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(UserRole.class)));
        subject.addUser((String) elements[0], (String) elements[1],(String)elements[2],roles);
        return "Paper" + elements[0] + "assigned to PCM" + subjectID + "for review";
    }

    @Override
    public Object getSubject(UUID id) {
        return null;
    }

    @Override
    public boolean checkPermissions(User actor) {
        EnumSet<UserRole> validRoles = EnumSet.of(UserRole.ADMIN);
        return validRoles.contains(actor.getCurrentRole());
    }

}