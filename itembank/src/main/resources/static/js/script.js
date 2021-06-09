'use strict';

$(document).on('click', 'a[href="#"]', function(e){
    e.preventDefault();
});

//gnb메뉴
$(function(){
    $('header .menuOpen').on('click', function(){
        $('.gnb').addClass('on');
    });
    $('.gnb .close, section').on('click', function(){
        $('.gnb').removeClass('on');
    });
});


//fixHeader
var scrollTop = 0;
scrollTop = $(document).scrollTop();
fixHeader();

//윈도우창 조절시 이벤트 아래에 on은 그룹 이벤트 등록 메소드임
$(window).on('scroll resize', function(){
    scrollTop = $(document).scrollTop();
    fixHeader();
});


//고정해더 함수
function fixHeader() {
    if(scrollTop>150) {
        $('header').addClass('on');
        // css의 header의 on클래스를 추가
    } else{
        $('header').removeClass('on');
    }
}

//스크롤 애니메이션
$(function(){
    $('.animate').scrolla({
        mobile: false,
        once: false
    });
});

//상단으로 부드럽게
$(function(){
    $('.goTop').on('click', function(){
        $('html, body').animate({scrollTop:0}, 500);
    });
});

//.top-visual 이미지 슬라이드
$(function(){
  $('.visual .slide').slick({
    arrow : true, //화살표
    dots : false, //인디케이트 해제
    fade : true, //페이드인효과(서서히 나타나는것)
    autoplay : true, // 자동재생
    autoplaySpeed:4000, // 재생시간 4000=4초
    pauseOnHover : false,
    pauseOnFocus : false
});
  });

