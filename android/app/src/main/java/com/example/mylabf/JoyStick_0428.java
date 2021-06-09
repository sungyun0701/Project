package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class JoyStick_0428 extends AppCompatActivity {

    private TextView angleTextView,angleTextViewLab, powerTextView,powerTextViewLab, directionTextView,directionTextViewLab,front_textView,back_textView,right_textView,left_textView;
    private JoystickView1 joystick;

    public static String CMD = "0";
    //서버주소
    public static final String sIP = "192.168.70.6";
    //사용할 통신 포트
    public static final int sPORT = 5900;
    //데이터 보낼 클랙스
    public SendData mSendData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joy_stick_0428);

        angleTextView = (TextView)findViewById(R.id.angleTextView);
        powerTextView = (TextView)findViewById(R.id.powerTextView);
        directionTextView = (TextView)findViewById(R.id.directionTextView);
        joystick = (JoystickView1) findViewById(R.id.joystickView);

        joystick.setOnJoystickMoveListener(new JoystickView1.OnJoystickMoveListener() {
            @Override
            public void onValueChanged(int angle, int power, int direction) {
                angleTextView.setText(" " + String.valueOf(angle) + "°");
                powerTextView.setText(" " + String.valueOf(power) + "%");
                switch (direction) {
                    case JoystickView1.FRONT:
                        directionTextView.setText(R.string.front_lab);
                        mSendData = new SendData();
                        CMD="FF,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    case JoystickView1.FRONT_RIGHT:
                        directionTextView.setText(R.string.front_right_lab);
                        mSendData = new SendData();
                        CMD="FR,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    case JoystickView1.RIGHT:
                        directionTextView.setText(R.string.right_lab);
                        mSendData = new SendData();
                        CMD="RR,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    case JoystickView1.RIGHT_BOTTOM:
                        directionTextView.setText(R.string.right_bottom_lab);
                        mSendData = new SendData();
                        CMD="BR,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    case JoystickView1.BOTTOM:
                        directionTextView.setText(R.string.bottom_lab);
                        mSendData = new SendData();
                        CMD="BB,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    case JoystickView1.BOTTOM_LEFT:
                        directionTextView.setText(R.string.bottom_left_lab);
                        mSendData = new SendData();
                        CMD="BL,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    case JoystickView1.LEFT:
                        directionTextView.setText(R.string.left_lab);
                        mSendData = new SendData();
                        CMD="LL,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    case JoystickView1.LEFT_FRONT:
                        directionTextView.setText(R.string.left_front_lab);
                        mSendData = new SendData();
                        CMD="FL,80";
                        //보내기 시작
                        mSendData.start();
                        break;
                    default:
                        directionTextView.setText(R.string.center_lab);
                        mSendData = new SendData();
                        CMD="SS,00";
                        //보내기 시작
                        mSendData.start();
                }
            }
        }, JoystickView1.DEFAULT_LOOP_INTERVAL);
    }

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