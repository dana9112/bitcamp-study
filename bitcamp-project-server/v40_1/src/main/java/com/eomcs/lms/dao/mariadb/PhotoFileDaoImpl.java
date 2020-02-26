package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.util.ConnectionFactory;

public class PhotoFileDaoImpl implements PhotoFileDao {

  ConnectionFactory conFactory;

  public PhotoFileDaoImpl(ConnectionFactory conFactory) {
    this.conFactory = conFactory;
  }

  @Override
  public int insert(PhotoFile photoFile) throws Exception {
    try (Connection con = conFactory.getConnection(); //
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("insert into lms_photo_file(photo_id, file_path) values(" //
          + photoFile.getBoardNo() + ",'" + photoFile.getFilepath() + "')");

      return result;
    }
  }



  @Override
  public List<PhotoFile> findAll(int boardNo/* 게시물 번호 */) throws Exception {
    try (Connection con = conFactory.getConnection(); //
        Statement stmt = con.createStatement();

        // MariaDB의 lms_PhotoBoard 테이블에 있는 데이터를 가져올 도구를 준비
        ResultSet rs = stmt.executeQuery( // 테스트 꼭 하고 실행하기
            "select photo_file_id, photo_id, file_path" //
                + " from lms_photo_file " //
                + " where photo_id=" + boardNo //
                + " order by photo_file_id asc")) {

      ArrayList<PhotoFile> list = new ArrayList<>();
      while (rs.next()) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        // 1) 생성자를 통해 인스턴스 필드의 값을 설정하기
        // list.add(new PhotoFile(
        // rs.getInt("Photo_file_id"), //
        // rs.getString("file_path"), //
        // rs.getInt("photo_id")));

        // 2) 셋터를 통해 체인 방식으로 인스턴스 필드의 값을 설정하기 (요즘 트렌드)
        // 생성자를 만들어서 - 셋터명령어를 연속으로 쓸 수 있음 (동영)
        list.add(new PhotoFile()//
            .setNo(rs.getInt("Photo_file_id")) //
            .setFilepath(rs.getString("file_path")) //
            .setBoardNo(rs.getInt("photo_id")));

      }
      return list;
    }
  }


  @Override
  public int deleteAll(int boardNo) throws Exception {
    try (Connection con = conFactory.getConnection(); //
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate(//
          "delete from lms_photo_file " // 게시글을 지우는 것이 아니라 첨부파일을 지우는 것
              + " where photo_id=" + boardNo);
      return result;
    }
  }



}
