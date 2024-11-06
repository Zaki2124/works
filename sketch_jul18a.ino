#include <Wire.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_ADXL345_U.h>

Adafruit_ADXL345_Unified accel = Adafruit_ADXL345_Unified(12345);

float lastY = 0;
float velocity = 0;
float position = 50; // 初期位置（0-100の範囲）
float alpha = 0.8; // ローパスフィルタの係数

int b_pin = 4;   // デジタルデータ出力用ピン番号
int buttonState = 0;   // ピンより取得したデータ格納用
int lastButtonState = 0;

void setup() {
  Serial.begin(9600);
  
  if(!accel.begin()) {
    Serial.println("ADXL345 not detected. Check wiring!");
    while(1);
  }
  
  accel.setRange(ADXL345_RANGE_2_G);
  
  pinMode(b_pin, INPUT_PULLUP);     // ボタンスイッチ用に入力に設定
  
  Serial.println("ADXL345 initialized");
}

void loop() {
  sensors_event_t event; 
  accel.getEvent(&event);
  
  float y = event.acceleration.y;
  
  // ローパスフィルタを適用
  y = alpha * y + (1 - alpha) * lastY;
  
  // 速度を計算（簡易的な積分）
  velocity = velocity * 0.95 + (y - lastY) * 20; // 乗数を20に設定して感度を上げる
  
  // 位置を更新
  position += velocity;
  position = constrain(position, 0, 100);
  
  lastY = y;
  
  // 加速度データを送信
  Serial.print(y, 2);  // 小数点以下2桁まで出力
  Serial.print("\t");
  Serial.print(velocity, 2);
  Serial.print("\t");
  Serial.println(position, 2);
  
  // ボタンの状態を読み取り
  buttonState = !digitalRead(b_pin);
  
  // ボタンの状態が変化した場合のみ送信
  if (buttonState != lastButtonState) {
    Serial.println(buttonState);
    lastButtonState = buttonState;
  }
  
  delay(50); // 20Hzでデータを送信
}