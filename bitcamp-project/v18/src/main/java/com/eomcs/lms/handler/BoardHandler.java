package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  ArrayList<Board> boardList; // 변수 자체가 레퍼런스이다. 그래서 생성자가 필요하다. 

  Scanner input;

  public BoardHandler(Scanner input) { // 생성자 : 스케너를 통해 데이터를 넣는다.
    this.input = input;
    boardList = new ArrayList<>(); // Board를 적지 않아도  지정되어 있으면 생략해도 된다. / 속을 비워 둔 채로 나둠
  }

  public void listBoard() {
    // BoardList의 배열에 보관된 값을 받을 배열을 준비한다.
    Board[] arr = new Board[this.boardList.size()];
    
    // toArray()에게 빈 배열을 넘겨서 복사 받는다.
    this.boardList.toArray(arr);
    
    for (Board b : arr) {
      //Board b = (Board) obj; // !이해가 안되는 부분! // 생략할 수 있음
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(input.nextInt());
    input.nextLine(); 

    System.out.print("내용? ");
    board.setTitle(input.nextLine());

    board.setDate(new Date(System.currentTimeMillis()));
    board.setViewCount(0);

    boardList.add(board);
    System.out.println("저장하였습니다.");
  }

  public void detailBoard() {
    System.out.print("게시물 인덱스? ");
    int idx = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    Board board = this.boardList.get(idx); // 보드 값에 데이터가 있다는 것을 알려주는 것.
    if (board == null) {
      System.out.println("게시물 인덱스가 유효하지 않습니다.");
      return;
    }

    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

}









