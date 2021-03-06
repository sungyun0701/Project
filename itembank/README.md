# 간단 소개

- **Made by SungYun Hwang** 
- **문제은행 웹사이트 만들기(with Java Spring Data JPA)**
- **언어 및 작업툴**: JAVA(Version 15.0.2),HTML,CSS,JAVASCRIPT // Eclipse(Version 4.17.0), Mysql Workbench 8.0, Visual Studio Code(Version 1.57.1)
- **프레임** : SPRING DATA JPA


# 프로젝트 상세내용

## :point_right: 주제

- **문제와 간단한 게임을 푸는 반응형 웹페이지 구현**

## :point_right: 목적

- **MVC 설계와 데이터베이스 간의 통신을 이해하고, 스프링 시큐리티를 적용해 권한별 웹페이지를 구현하고, 홈페이지 첫화면은 반응형으로 설계하며, 기본적인 게임과 문제를 푸는 웹페이지 구현**



## :point_right: 구현 목표
<pre>
1. 문제은행을 통해 문제 풀고 점수 확인할 수 있는 웹페이지 구현<br>
 - 첫 화면은 반응형으로 구성<br>
2. Mysql과 연동하여 데이터를 주고 받을 수 있게 구현<br>
 - 유저에 따른 ROLE설정 및 점수 관리<br>
3. 권한에 따른 웹페이지 접근 권한 설정<br>
 - ADMIN 계정으로만 유저에 대한 정보 수정 및 삭제 할 수 있게 설정<br>
</pre>

## :point_right: 설계 및 구동화면
---
### **초기 Dependencies 설정**<br>
---
<img src="../image/spring0.png"  width="700" height="700"><br>
___
### **비밀번호 암호화 및 토큰 생성**<br>
---
<img src="../image/spring2.png"  width="700" height="700"><br>
___
### **시큐리티 적용해 관리자 파일 구분 및 로그인 로그아웃 관리**<br>
---
<img src="../image/spring3.png"  width="700" height="700"><br>
___
### **Control, Entity, Repository, Class List**<br>
---
<img src="../image/spring4.png"><br>  
___
### **Template 구성 요소**<br>
---
<img src="../image/spring5.png"><br>
___
### **CSS파일내에 반응형으로 구현하기 위한 소스코드**<br>
---
<img src="../image/spring6.png"  width="700" height="700"><br>
___
### **홈페이지 첫 화면(반응형)**<br>
---
<img src="../Item_Bank.gif" alt="Loading...Fail?"><br>
  - **화면 크기별 레이아웃(관리자로 로그인)**<br>
    <img src="../image/login.gif" width="1280" height="450"><br>
    - 1200×782
    ![image](https://user-images.githubusercontent.com/80665580/127956741-1ce39b1d-f9cd-4056-bb8b-08673a05e704.png)
    - 1024×704
    ![image](https://user-images.githubusercontent.com/80665580/127957035-339d2a76-6468-4d2b-a9fe-ce388306f7dc.png)
    - 768×704
    ![image](https://user-images.githubusercontent.com/80665580/127957095-2da3676c-f806-4921-b610-a90a351b1229.png)
    - 650×704
    ![image](https://user-images.githubusercontent.com/80665580/127957270-a73ad641-1218-4d9d-83b7-d8e8c797fc81.png)
  - **관리자 권한으로 점수 확인 페이지**
    ![image](https://user-images.githubusercontent.com/80665580/128175642-03d5b806-7bde-45f1-a010-5c6d4126f550.png)
  - **일반 유저 권한으로 점수 확인 페이지**  
    ![image](https://user-images.githubusercontent.com/80665580/128175777-b2c47794-cd2f-4a74-8553-57fd458f9bc6.png)

  - **회원가입 화면**<br>
<img src="../image/signup.png" width="1280" height="450"><br>
  - **문제 푸는 화면**<br>
<img src="../image/solve.gif" width="1280" height="450"><br>
  - **로그아웃 화면**<br>
<img src="../image/logout.gif" width="1280" height="450"><br>
