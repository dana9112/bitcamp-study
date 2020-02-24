package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDetailServlet implements Servlet {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardDetailServlet(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("사진 게시글 번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    PhotoBoard photoboard = photoBoardDao.findByNo(no);

    if (photoboard != null) {
      out.printf("번호: %d\n", photoboard.getNo());
      out.printf("제목: %s\n", photoboard.getTitle());
      out.printf("등록일: %s\n", photoboard.getCreatedDate());
      out.printf("조회수: %d\n", photoboard.getViewCount());
      out.printf("수업: %s\n", photoboard.getLesson().getTitle());
    } else {
      out.println("해당 번호의 사진 게시물이 없습니다.");
    }
  }
}
