package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonObjectFileDao extends AbstractObjectFileDao<Lesson> {


  public LessonObjectFileDao(String filename) {
    super(filename);
  }

  public int insert(Lesson lesson) throws Exception {

    if (indexOf(lesson.getNo()) > -1) {
      return 0;
    }

    list.add(lesson);
    saveData();
    return 1;
  }

  public List<Lesson> findAll() throws Exception {
    return list;
  }

  public Lesson findByNo(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Lesson lesson) throws Exception {
    int index = indexOf(lesson.getNo());

    if (index == -1) {
      return 0;
    }
    list.set(index, lesson);
    return 0;
  }

  public int delete(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  // 수퍼클래스보다 접근 범위를 좁게 할 수 없기 때문에 private를 사용 할 수 없다.
  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i;
      }
    }
    return -1;
  }

}
