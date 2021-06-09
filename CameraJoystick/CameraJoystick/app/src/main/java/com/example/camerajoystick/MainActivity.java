package com.example.camerajoystick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout_joystick;
    ImageView image_joystick, image_border;
    TextView textView1, textView2, textView3, textView4, textView5;
    WebView mWebView;
    WebSettings webSettings;
    JoyStickClass js;

    public static String CMD = "0";
    // 서버주소
    public static final String sIP = "192.168.70.6";
    public static final int sPORT = 5900;
    //데이터 보낼 클랙스
    public SendData mSendData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textView5 = (TextView)findViewById(R.id.textView5);

        mWebView = (WebView)findViewById(R.id.webView);//xml 자바코드 연결
        mWebView.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용

        mWebView.loadUrl("http://192.168.70.6:8081");//웹뷰 실행
        mWebView.setWebChromeClient(new WebChromeClient());//웹뷰에 크롬 사용 허용//이 부분이 없으면 크롬에서 alert가 뜨지 않음

        layout_joystick = (RelativeLayout)findViewById(R.id.layout_joystick);

        js = new JoyStickClass(getApplicationContext(), layout_joystick, R.drawable.image_button);
        js.setStickSize(150, 150);
        js.setLayoutSize(500, 500);
        js.setLayoutAlpha(150);
        js.setStickAlpha(100);
        js.setOffset(90);
        js.setMinimumDistance(50);

        layout_joystick.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent event) {
                js.drawStick(event);
                if(event.getAction() == MotionEvent.ACTION_DOWN
                        || event.getAction() == MotionEvent.ACTION_MOVE) {
                    textView1.setText("X : " + String.valueOf(js.getX()));
                    textView2.setText("Y : " + String.valueOf(js.getY()));
                    textView3.setText("Angle : " + String.valueOf(js.getAngle()));
                    textView4.setText("Distance : " + String.valueOf(js.getDistance()));

                    int direction = js.get8Direction();
                    if(direction == JoyStickClass.STICK_UP) {
                        textView5.setText("Direction : Up");
                        mSendData = new SendData();
                        CMD="FF,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_UPRIGHT) {
                        textView5.setText("Direction : Up Right");
                        mSendData = new SendData();
                        CMD="FR,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_RIGHT) {
                        textView5.setText("Direction : Right");
                        mSendData = new SendData();
                        CMD="RR,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_DOWNRIGHT) {
                        textView5.setText("Direction : Down Right");
                        mSendData = new SendData();
                        CMD="BR,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_DOWN) {
                        textView5.setText("Direction : Down");
                        mSendData = new SendData();
                        CMD="BB,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_DOWNLEFT) {
                        textView5.setText("Direction : Down Left");
                        mSendData = new SendData();
                        CMD="BL,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_LEFT) {
                        textView5.setText("Direction : Left");
                        mSendData = new SendData();
                        CMD="LL,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_UPLEFT) {
                        textView5.setText("Direction : Up Left");
                        mSendData = new SendData();
                        CMD="FL,80";
                        //보내기 시작
                        mSendData.start();
                    } else if(direction == JoyStickClass.STICK_NONE) {
                        textView5.setText("Direction : Center");
                        mSendData = new SendData();
                        CMD="SS,00";
                        //보내기 시작
                        mSendData.start();
                    }
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    textView1.setText("X :");
                    textView2.setText("Y :");
                    textView3.setText("Angle :");
                    textView4.setText("Distance :");
                    textView5.setText("Direction :");
                    mSendData = new SendData();
                    CMD="SS,00";
                    //보내기 시작
                    mSendData.start();
                }
                return true;
            }
        });
    }

    //데이터 보내는 쓰레드 클래스
    private class SendData extends Thread {
        public void run(){
            try{
                //UDP 통신용 소켓 생성
                DatagramSocket socket = new DatagramSocket();
                //서버 주소 변수
                InetAddress serverAddr = InetAddress.getByName(sIP);

                //보낼 데이터 생성
                byte[] buf = CMD.getBytes();

                //패킷으로 변경
                DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, sPORT);

                //패킷 전송!
                socket.send(packet);

//                //데이터 수신 대기
//                socket.receive(packet);
//                //데이터 수신되었다면 문자열로 변환
//                String msg = new String(packet.getData());
//                //txtView에 표시
//                txtView.setText(msg);
            }catch (Exception e){

            }
        }
    }
}
