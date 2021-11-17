시리얼 통신 시작하기

void setup(){ //한 번만 실행
Serial.begin(9600); //시작
}
void loop(){//계속 반복
Serial.println("Hello"); //Hello
delay(1000);//1초 멈춤
}

Serial.available() => 아두이노가 상대방으로부터 받은 데이터가 있는지 확인
Serail.read => 한 바이트를 잘라내 읽는 명령어

pinMode(13, IN/OUTPUT); => 핀 모드를 출력or입력 설정하는 함수 
degitalWrite() => 핀의 전압을 HIGH 또는 LOW로 설정하는 함수

randomSeed() => 난수로 뽑을 숫자들을 섞는 함수
delayMicroseconds() => 아두이노 보드를 일정 시간 멈추는 함수
LiquidCrystal.clear() => LCD에 있는 모든 글자를 지움
ex)lcd.clear(); //LCD에 찍힌 모든 글자를 지웁니다.
