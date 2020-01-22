package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

// "/hello" 명령 처리
public class ComputePlusCommand implements Command {
  Prompt prompt;

  public ComputePlusCommand(Prompt prompt) {
    this.prompt = prompt;
  }



  @Override
  public void execute() {
    int no1 = prompt.inputInt("수1? ");
    int no2 = prompt.inputInt("수2? ");
    int p1 = no1 + no2;

    System.out.printf("계산결과는? %d 입니다.\n", p1);
  }

}


