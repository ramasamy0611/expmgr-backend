package com.ram.projects.expmgr.rest.converter;

import com.ram.projects.expmgr.db.entity.ExpMgrUser;
import com.ram.projects.expmgr.rest.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserOutputConverter implements Converter<ExpMgrUser, User> {
    @Override
    public User convert(ExpMgrUser input) {
        User user = new User(input.getId(), input.getFirstName(), input.getLastName(), input.getCreationDate().toString(), input.getModifiedDate().toString(), input.geteEmail());
        user.setComment(input.getComment());
        user.setType(user.getType());
        return user;
    }
}
