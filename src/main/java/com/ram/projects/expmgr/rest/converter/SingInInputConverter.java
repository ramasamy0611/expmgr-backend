package com.ram.projects.expmgr.rest.converter;

import com.ram.projects.expmgr.db.entity.ExpMgrSignIn;
import com.ram.projects.expmgr.rest.dto.SignIn;
import org.springframework.stereotype.Component;

@Component
public class SingInInputConverter implements Converter<SignIn, ExpMgrSignIn> {
  @Override
  public ExpMgrSignIn convert(SignIn input) {
    return new ExpMgrSignIn(input.getUserName(), input.getPassword(), input.getEncryptionKey());
  }
}
