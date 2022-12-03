# 웹페이지 페이징 및 파일 다운로드 구현 미니 프로젝트

### [진행 기간]

- 2022.11.24 ~ 2022.11.25

### [프로젝트 소개]

부트캠프 **파이널 프로젝트에 들어가기 전**에 커리큘럼 마지막 과정으로 배운 **Spring boot와 React**를 사용하여 웹페이지에 **페이징과 파일 다운로드**를 구현해보는 부트캠프에서의 **마지막 미니 프로젝트**였습니다. 

직전 미니 프로젝트와 동일한 역할 분배로 진행하여 저는 **백엔드**를 맡아 기본적인 **MVC패턴 구현** 및 Diary Entity를 이용하여 **diary_no**를 통해 Diary Entity와 **외래키** 관계에 있는 File Entity의 데이터를 참고하여 웹페이지에서의 **파일 다운로드 구현해보고** 

한 페이지에 보여지는 **size를 5로 설정**하여 웹페이지 **게시판의 페이징 구현**을 목표로 진행하였습니다. 

### [프로젝트 진행 중 겪은 문제점 및 아쉬웠던 점]

1. **@Query**를 이용하여 **메소드 위에 정적 쿼리를 작성**하여 메소드를 정의하였는데 **해당 쿼리문을 인식하지 못하는 문제**를 겪었습니다.
알고보니 **쿼리문 작성시** DB에 **테이블명**이 file이어도 첫글자가 대문자인 File로 입력했어야 하는데 **file로 입력**한 것이 원인인 것을 발견하여 테이블명을 **file → File로 수정후 문제를 해결**하였습니다. 

2. 게시판에서 파일 다운로드를 시도할 때 **지정한 경로에 파일이 없는데도 자동으로 download라는 이름의 빈 파일로 다운로드가 실행되는 문제**를 발견하였습니다.
**조건문**을 이용하여 파일이 없을 경우 **HttpHeaders 객체에는 null**을 **HttpStatus에는 NOT_FOUND**를 적용한 **ResponseEntity를 반환**하여 파일이 없는데 다운로드를 실행하면 오류 페이지가 뜨도록 함으로써 해결하였습니다.

3. **페이지 번호** 선택 버튼에서 1번이 아닌 버튼을 클릭한 후 **다시 1번 버튼을 누르면 처음 순서가 아닌 2번째 순서** 페이지가 출력되는 문제가 발생하였는데
**프론트에서 페이지가 1부터 백엔드에서는 0부터 시작**하는 차이가 원인이었고 **PageRequest.of**을 통해 Pageable 객체 생성시 page인자에 **page ⇒** **page-1**로 수정함으로써 해결하였습니다.  

![KakaoTalk_20221201_202236465](https://user-images.githubusercontent.com/109947297/205433146-526cd6bd-fb4f-4d64-97dc-3b142301bf3c.png)
![KakaoTalk_20221201_202236717](https://user-images.githubusercontent.com/109947297/205433150-83ddfd22-010a-49bc-bf49-dfccd7f58aac.png)


4. **Github에 Spring Boot 프로젝트 파일 커밋**시 **.maven 폴더와 .settings 폴더가 push 되지 않아 다른 팀원들이 pull 한 후**에 프로젝트를 import를 시도했을 때 **import가 불가능**한 문제가 발생하였는데 
해당 프로젝트의 .gitignore 파일에서 해당 부분을 지우고 commit+push를 하니 .maven 폴더와 .settings 폴더가 **GitHub에 성공적으로 push**되었고 **import도 정상적으로 가능**함을 확인함으로써 해결하였습니다.

---

![DB 다이어그램](https://user-images.githubusercontent.com/109947297/204556659-6a031f66-6cca-4772-8572-ebec675812d7.PNG)

![웹페이지 화면](https://user-images.githubusercontent.com/109947297/204556811-a67a2012-a789-4631-8d77-ca0015c60ee1.PNG)

![다운로드](https://user-images.githubusercontent.com/109947297/204556623-4b2f42c8-f9d0-47de-aa82-f65413f0af66.PNG)

    CRUD 테스트를 진행하다보니 게시판의 첫 페이지의 첫 파일 number가 1이 아닌 8이 되었음을 참고바랍니다.

![다운로드 실패](https://user-images.githubusercontent.com/109947297/204556552-6e7b5af7-f5c4-43af-b749-05bcead2a3fd.PNG)


