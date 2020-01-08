// 게시글 번호로 객체를 찾는

package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList1;

public class BoardHandler {

  ArrayList1<Board> boardList; // 변수 자체가 레퍼런스이다. 그래서 생성자가 필요하다. 

  Scanner input;

  public BoardHandler(Scanner input) { // 생성자 : 스케너를 통해 데이터를 넣는다.
    this.input = input;
    boardList = new ArrayList1<>(); // Board를 적지 않아도  지정되어 있으면 생략해도 된다. / 속을 비워 둔 채로 나둠
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
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거

    // 게시글 번호로 객체를 찾는다.
    int index = indexOfBoard(no);
    /*
    Board board = null;
    for (int i = 0; i < this.boardList.size(); i++) {
      Board temp = this.boardList.get(i);
      if (temp.getNo() == no) {
        board = temp;
        break;
      }
    }
     */  
    if (index == -1) {
      System.out.println("해당 번호의 게시글이 유효하지 않습니다.");
      return;
    }
    
    Board board = this.boardList.get(index);
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
  }

  public void updateBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    // 게시글 번호로 찾는다.
    int index = indexOfBoard(no);
    /*
    Board oldBoard = null;
    int index = -1;
    for (int i = 0; i < this.boardList.size(); i++) {
      Board temp = this.boardList.get(i);
      if (temp.getNo() == no) {
        oldBoard = temp;
        index = i;
        break;
      }
    }
*/
    if (index == -1) {
      System.out.println("해당번호의 게시글이 없습니다.");
      return;
    }
    
    Board oldBoard = this.boardList.get(index);
    System.out.printf("내용(%s)? ", oldBoard.getTitle());
    String title = input.nextLine();

    if (title.length() == 0) {
      System.out.println("게시글 변경을 취소했습니다.");
      return;
    }

    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setTitle(title);
    newBoard.setDate(new Date(System.currentTimeMillis()));

    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다.");
  }

  public void deleteBoard() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine(); // 숫자 뒤의 남은 공백 제거
    
    // 게시글 번호로 객체를 찾는다.
    int index = indexOfBoard(no);
    /*
    Board board = null;
    int index = -1;
    for (int i = 0; i < this.boardList.size(); i++) {
      Board temp = this.boardList.get(i);
      if (temp.getNo() == no) {
        board = temp;
        index = i;
        break;
      }
    }
    */
    
    if (index == -1) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      return;
    }

    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다.");
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}









