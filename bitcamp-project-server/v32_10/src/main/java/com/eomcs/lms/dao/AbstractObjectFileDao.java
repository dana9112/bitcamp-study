package com.eomcs.lms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

// 4. 서브 클래스에게 공통 필드나 상속해주는 역할을 하기 때문에
// => abstract
// 서브 클래스에게 상속 해주는 메서드 중에서 indexOf() 처럼 구현되지 않은 메서드가 있기 때문에
// => abstract
//
public abstract class AbstractObjectFileDao<T> { // K 도 같이 정의해줄 수 있다. => <T,K>
  // 1. list의 값을 board or member or lesson으로 고정시킬 수 없기 때문에 타입정보를 받는 타입 파라미터를 넣어준다.

  protected String filename;
  protected List<T> list;

  public AbstractObjectFileDao(String filename) { // 파일 이름을 생성자에서 받는다.
    this.filename = filename;
    list = new ArrayList<>();
    loadData(); // 파일에 객체가 생성되었을때 로딩된다.
  }

  @SuppressWarnings("unchecked")
  // 2. 같은 패키지에 있는 클래스도 사용할 수 있고 서브클래스 누구나 사용할 수 있도록 protected로 변경해준다.
  protected void loadData() {
    File file = new File(filename);

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      list = (List<T>) in.readObject();
      System.out.printf("총 %d 개의 객체를 로딩했습니다.\n", list.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  protected void saveData() {
    File file = new File(filename);

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.reset(); // 기존의 직렬화(serialize) 수행 중에 캐시된(임시보관된) 데이터를 초기화시킨다.
      out.writeObject(list);
      System.out.printf("총 %d 개의 객체를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());

    }
  }

  // 서브 클래스들의 공통 메서드이기 때문에
  // => 수퍼 클래스에 정의한다.
  // 서브 클래스에서 접근할 수 있어야 하기 때문에
  // => modifier를 protected로 변경한다.
  // 서브 클래스마다 구현 방법이 다르기 때문에
  // => abstract
  // => 수퍼 클래스에서 구현할 수도 없고, 구현해 봐야 소용없다.
  // 3. 서브 클래스에서 반드시 구현해야 할 메서드이기 때문에
  // => abstract
  //
  protected abstract <K> int indexOf(K key); // 5. k는 타입을 가르키는 파라미터다.


}
