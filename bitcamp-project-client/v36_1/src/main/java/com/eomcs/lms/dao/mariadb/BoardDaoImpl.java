package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

  @Override
  public int insert(Board board) throws Exception {
    // JDBC Driver(MariaDB 프록시)를 로딩한다.
    Class.forName("org.mariadb.jdbc.Driver");

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      // DBMS에게 데이터 입력하라는 명령을 보낸다. (인서트 업데이트 할때 사용하는 것!!!
      // SQL문법: insert into 테이블명(컬럼명1, 컬럼명2, .... ) values(값1, 값2, ....)
      // => executeUpadate()의 리턴 값은 서버에 입력된 데이터의 개수이다.
      int result =
          stmt.executeUpdate("insert into lms_board(conts) values('" + board.getTitle() + "')");

      return result;
    }
  }

  @Override
  public List<Board> findAll() throws Exception {
    // Stateless 방식으로 접근함.
    // JDBC Driver(MariaDB 프록시)를 로딩한다.
    Class.forName("org.mariadb.jdbc.Driver");

    try (
        // JDBC Driver를 이용하여 MariaDB에 접속한다.
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

        // MariaDB에 명령을 전달할 객체 준비
        Statement stmt = con.createStatement();

        // MariaDB에 lms_board의 테이블에 있는 데이터를 가져올 도구를 준비
        ResultSet rs = stmt.executeQuery("select board_id, conts, cdt, vw_cnt from lms_board")) {


      ArrayList<Board> list = new ArrayList<>(); // 4. 담은 메모리를 arraylist에 닮

      // ResultSet 도구를 사용하여 데이터를 하나씩 가져온다.
      while (rs.next()) { // 데이터를 한 개 가져왔으면 true를 리턴한다.
        Board board = new Board(); // 1.새로운 보드 메모리를 가지고 오고

        // 2/서버에서 가지고 온 데이터를 꺼내서
        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("conts"));
        board.setDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));

        // 3. 값을 보드의 메모리에 담고
        list.add(board);

      }
      return list;
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    // JDBC Driver(MariaDB 프록시)를 로딩한다.
    Class.forName("org.mariadb.jdbc.Driver");

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_id, conts, cdt, vw_cnt from lms_board where board_id=" + no)) {


      if (rs.next()) { // 데이터를 한개 가지고 오면 true를 리턴한다.
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("conts"));
        board.setDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));
        return board;

      } else {
        return null;
      }
    }
  }

  @Override
  public int update(Board board) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      // DBMS에게 데이터를 변경하라는 명령을 보낸다. (인서트 업데이트 할때 사용하는 것!!!
      // SQL문법:
      // => update 테이블명 set 컬럼명1=값1, 컬럼명2=값2, .... where 조건
      // => executeUpadate()의 리턴 값은 SQL 명령에 따라 변경된 데이터의 개수이다.
      int result = stmt.executeUpdate(
          "update lms_board set conts = '" + board.getTitle() + "' where board_id" + board.getNo());

      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver");

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      // DBMS에게 데이터를 변경하라는 명령을 보낸다. (인서트 업데이트 할때 사용하는 것!!!
      // SQL문법:
      // => delete from 테이블명 where 조건
      // => executeUpadate()의 리턴 값은 SQL 명령에 따라 변경된 데이터의 개수이다.
      int result = stmt.executeUpdate("delete from lms_board where board_id=" + no);

      return result;
    }
  }

}
