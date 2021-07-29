# 진행한 프로젝트(4개)

## Project_JAVA

:point_right: **Solve a QUIZ(Itembank)**  
- **언어 및 작업툴**: JAVA(Version 15.0.2),HTML,CSS,JAVASCRIPT // Eclipse(Version 4.17.0), Mysql Workbench 8.0, VS Code(Version 1.57.1)
- **프레임** : SPRING DATA JPA
- **내용**
  - 뷰 템플릿으로 thymeleaf를 사용하여 구성화면과의 데이터를 전달하게 구성.
  - 에러 컨트롤러를 구현하여 에러페이지 관리하도록 구성.
  - java Security를 통해 관리자 페이지, 일반회원페이지 관리 및 접근 제한, 로그인 및 로그아웃 관리 등을 하도록 함.
  - 이 프로젝트는 데이터베이스로 Mysql을 사용.
  - 문제은행 및 로또 생성기, BMI, 간단한 계산기를 구현
  - Admin 계정으로 로그인 시 회원정보를 수정 및 삭제 가능
  - index(첫화면페이지)는 반응형웹으로 구현(가로길이가 1200,1024,768,650px에 따른 변화)
- **관련 화면**
  - 결과 화면    
![Loading...Fail](/Item_Bank.gif)
<br>

## Project_Python

:point_right: **Find Pharmacy within selected radius(djangoPharmacy)**  
- **언어 및 작업툴**: Python(Version 3.9.2),HTML,CSS,JAVASCRIPT // Pycharm(Version 2021.1.2), MongoDB Atlas(Version 4.4.6)
- **프레임** : Django 
- **내용**
  - data.go.kr에서 csv로 파일로 다운 받을 것을 MongoDB에 업로드
  - pymongo를 통한 MongoDB에 있는 데이터 임포트
  - Google Map을 임포트하여 기본적인 위치 설정 
  - 검색을 통해 해당 지역에 선택한 반경 내에 있는 약국들을 표시
  - 지도에 표시한 약국 위에 mouceover시 테이블에 해당 약국 정보 표시(색을 다르게 표시)
- **관련 화면**
  - 약국 데이터 관련 페이지
![](/pharmacy1.png)   
  - 대구역 중심으로 반경 1000m내에 있는 약국 표시
![](/pharmacy.png)   
<br>

:point_right: **Movie Data Crawling from naver(flaskNaverMovie_Mongdb)**
- **언어 및 작업툴**: Python(Version 3.9.2),HTML,CSS,JAVASCRIPT // Pycharm(Version 2021.1.2), MongoDB Atlas(Version 4.4.6)
- **프레임** : flask 
- **내용**
  - BeautifulSoup를 이용해 네이버 영화 페이지에서 원하는 정보를 크롤링하여 MongoDB에 저장
  - 크롤링 한 데이터를 원하는 형식에 적용하여 웹페이지에 표시
- **관련 화면**
  - 네이버 영화 관련 페이지
![](/movie2.png)
  - 크롤링 한 결과를 화면에 표시
![](/movie3.png)

<br>

## Project_Android with Raspberry Pi

:point_right: **RC Car Control with Motion Package(CameraJoystick)**
- **언어 및 작업툴**: Python(Version 3.9.2),JAVA(Version 15.0.2) // Raspberry Pi3, Android-Studio(Version 4.2.1)
- **내용**
  - 앱에서 데이터를 Raspberry Pi로 주면 RC Car를 제어할 수 있게 소스코드 작성
  - Joystick 소스코드를 자바로 안드로이드 앱으로 실행되게 작성
  - motion 패키지를 통해 웹상에서 표시되도록 연동(안드로이드 앱에서도 화면 구성)
  - WiFi를 통해 앱과 라즈베리파이가 통신이 되도록 구성
- **관련 화면**
  - RC car를 휴대폰 어플로 제어한 화면 <br>
![](/rc.gif) 
