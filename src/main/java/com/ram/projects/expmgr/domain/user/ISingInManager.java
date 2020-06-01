package com.ram.projects.expmgr.domain.user;

import com.ram.projects.expmgr.db.entity.ExpMgrSignIn;
import com.ram.projects.expmgr.db.entity.ExpMgrSignUp;
import com.ram.projects.expmgr.rest.dto.SignUp;

import java.util.concurrent.CompletableFuture;

public interface ISingInManager {
  CompletableFuture<ExpMgrSignIn> signIn(ExpMgrSignIn signIn);

  CompletableFuture<String> signUp(ExpMgrSignUp expMgrSignUp);
}
