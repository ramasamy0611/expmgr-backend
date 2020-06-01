package com.ram.projects.expmgr.rest.process.rest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.ram.projects.expmgr.common.CommonUtils.isNull;

public final class RestProcessorUtil {
  private static final int numberOfThreadForFixedThreadPool = 15;
  private static Executor executor;

  public static Executor getExecutor() {
    return supplyExecutor();
  }

  private static Executor supplyExecutor() {
    if (isNull(executor)) {
      executor = Executors.newFixedThreadPool(numberOfThreadForFixedThreadPool);
    }
    return executor;
  }
}
