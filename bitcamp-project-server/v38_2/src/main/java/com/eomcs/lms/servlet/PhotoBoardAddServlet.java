package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  LessonDao lessonDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao, LessonDao lessonDao,
      PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao; // lms_photo
    this.lessonDao = lessonDao;
    this.photoFileDao = photoFileDao; // 얘가 있어서 lms_photo_file 테이블을 가지고 올 수 있다.
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    PhotoBoard photoBoard = new PhotoBoard();

    out.println("제목? ");
    out.println("!{}!");
    out.flush();
    photoBoard.setTitle(in.nextLine());

    out.println("수업 번호?? ");
    out.println("!{}!");
    out.flush();

    int lessonNo = Integer.parseInt(in.nextLine());
    Lesson lesson = lessonDao.findByNo(lessonNo);
    if (lesson == null) {
      out.println("수업 번호가 유효하지 않습니다.");
      return;
    }

    lesson.setNo(lessonNo);

    photoBoard.setLesson(lesson);

    if (photoBoardDao.insert(photoBoard) > 0) {

      // 첨부파일을 입력 받는다.
      out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      out.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

      ArrayList<PhotoFile> photoFiles = new ArrayList<>();

      while (true) {
        out.println("사진 파일? ");
        out.println("!{}!"); // 사용자가 직접 입력하라는 커서가 있다는 것!
        out.flush();
        String filepath = in.nextLine();

        if (filepath.length() == 0 /* 입력하지 않은 것 */) {
          if (photoFiles.size() > 0) {
            break;
          } else {
            out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          }
        }

        // 1) 기본 생성자를 사용할 때,
        // PhotoFile photoFile = new PhotoFile();
        // photoFile.setFilepath(filepath);
        // photoFile.setBoardNo(photoBoard.getNo());
        // photoFiles.add(photoFile);

        // 2) 초기 값을 설정하는 생성자를 사용할 때,
        // photoFiles.add(new PhotoFile(filepath, photoBoard.getNo())); // 굳이 인스턴스 변수가 필요 없음

        // 3) 셋터 메서드를 활용하여 체인 방식으로 인스턴스 필드의 값을 설정 (실무에서 많이 씀)
        photoFiles.add(new PhotoFile()//
            .setFilepath(filepath)// 빈 객체를 만들고 그 빈 객체에 파일 패스를 만들어 값을 넣는다ㅣ.
            .setBoardNo(photoBoard.getNo()));
        // 단점은 리턴값을 제대로 체크를 못해서 디버깅할 때 어려움이 있다.
      }

      // ArrayList에 들어 있는 PhotoFile 데이터를 lms_photo_file 테이블에 저장한다.
      for (PhotoFile photoFile : photoFiles/* 처음부터 반복할때 이렇게 씀 */) {
        photoFileDao.insert(photoFile);
      }

      out.println("새 사진 게시글을 등록했습니다.");

    } else {
      out.println("게시글 등록에 실패했습니다.");
    }
  }
}
