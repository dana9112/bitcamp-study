# 40_3 - Connection을 스레드에 보관하기: 트랜젝션 적용하기 

## 학습목표

- ConnectionFactory를 통해 얻은 Connection 객체를 가지고 트랜젝션을 다루기

### 메서드 별로 커넥션을 개별화 한 상태에서 트랜잭션을 적용하기

- 39,40 단계로 가면서 커넥션을 메서드에서 준비하여 사용하였따.
- 이런 관계로 PhotoBoardAddServlet/PhotoBoardUpdateServlet/ PhotoBoardDeleteServlet
- 이제 다시 현 상태에서 트랜잭션 제어코드를 추가해보자. 

## 실습 소스 및 결과

- src/main/java/com/eomcs/sql/ConnectionProxy.java 추가
- src/main/java/com/eomcs/util/ConnectionFactory.java 변경
- src/main/java/com/eomcs/lms/ServletApp.java 변경

## 실습  

### 훈련1: PhotoBoardAddServler

- com.eomcs.sql.ConnectionProxy 추가
  - close()를 구현한다.
    - 호출되면 아무런 일을 하지 않게 한다.
    - 즉 커넥션을 닫지 않는다.
  - realClose() 추가한다.
    - 실제 커넥션을 닫는 일을 한다.
  - 나머지 메서드는 원래 Connection 객체에 위임한다.
    - eclipse / 소스창의 컨텍스트 메뉴 / source /generate delegate methods... 실행 
    
### 훈련2: ConnectionFactory가 ConnectionProxy 객체를 리턴하게 하라.

- com.eomcs.util.ConnectionFactory 변경
  - getConnection() 변경
  - 원래의 Connection 객체 대신에 ConnectionProxy를 리턴한다.
  
### 훈련3: 스레드에서 Connection을 제거하기 전에 서버와의 연결을 끊어라.

- com.eomcs.util.ConnectionFactory 변경
  - removeConnection()이 스레드에서 제거한 Connection을 리턴하게 변경한다.
- com.eomcs.lms.ServerApp 변경
  - ConnectionFactory에서 리턴 받은 Connection 객체에 대해 
    realClose()를 호출한다.
    
  