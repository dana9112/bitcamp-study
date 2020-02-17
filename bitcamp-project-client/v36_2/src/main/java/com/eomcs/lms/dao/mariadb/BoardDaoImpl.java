package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

  Connection con;

  public BoardDaoImpl(Connection con) {
    this.con = con;
  }



  @Override
  public int insert(Board board) throws Exception {

    try (Statement stmt = con.createStatement()) {
      int result =
          stmt.executeUpdate("insert into lms_board(conts) values('" + board.getTitle() + "')");

      return result;
    }
  }

  @Override
  public List<Board> findAll() throws Exception {
    try (Statement stmt = con.createStatement();
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
    try (Statement stmt = con.createStatement();
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
    try (Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate(
          "update lms_board set conts = '" + board.getTitle() + "' where board_id" + board.getNo());

      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Statement stmt = con.createStatement()) {

      // DBMS에게 데이터를 변경하라는 명령을 보낸다. (인서트 업데이트 할때 사용하는 것!!!
      // SQL문법:
      // => delete from 테이블명 where 조건
      // => executeUpadate()의 리턴 값은 SQL 명령에 따라 변경된 데이터의 개수이다.
      int result = stmt.executeUpdate("delete from lms_board where board_id=" + no);

      return result;
    }
  }

}
