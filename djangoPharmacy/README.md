# 간단 소개
- **Made by SungYun Hwang** 
- **지정한 장소 및 거리내의 약국 검색(Find Pharmacy within selected radius(djangoPharmacy))**
- **작업기간** : 
- **언어 및 작업툴**: Python(Version 3.9.2),HTML,CSS,JAVASCRIPT // Pycharm(Version 2021.1.2), Mongodb Atlas(Version 4.4.6)
- **프레임** : Django



# 프로젝트 상세내용
## :point_right: 주제
<pre>
* 목표로 한 위치에서 선택한 반경 내에 있는 약국 검색을 할 수 있는 웹사이트 구현
</pre>

## :point_right: 목적
<pre>
1. Django framework에 대한 이해와 nosql인 MongoDB와의 연결을 통한 활용
 - Python framework중 하나인 Django와 nosql를 활용한 웹페이지 구현<br>
2. 빅데이터를 활용할 방법 모색
 - csv파일을 통해 자료를 활용<br>
3. 구글맵 사용하고 활용할 수 있는 방법 이해
 - 입력받은 데이터에서 위치데이터를 활용하여 관련된 데이터 추출 및 활용
</pre>

## :point_right: 구현 목표
<pre>
* 구글 맵을 활용하여 입력 데이터에 대한 위치 데이터를 활용하여 관련된 데이터 추출<br>
* MongDB와의 연결 확인<br>
* 검색한 위치에 대한 반경을 입력 받아 지도에 표시<br>
* 지도에서 mouseover시 표에 표시되도록 구현
</pre>

## :point_right: 설계 및 구동화면<br>
<kbd><img src="../image/pharmacy.gif" width="1280" height="450"><br></kbd>
  - 공공데이터 포털 사이트(데이터 수집)
  ![image](https://user-images.githubusercontent.com/80665580/128316218-fb809cff-366a-4fd2-8f6d-3ed67ba61449.png)
  - MongoDB에 접속(Atlas MongoDB에 데이터는 Studio 3T를 사용해 약국 데이터 입력 // pymongo, dnspython 설치)
  ![image](https://user-images.githubusercontent.com/80665580/128329472-5014b8eb-c551-48bb-9c7b-c9272e68425f.png)



