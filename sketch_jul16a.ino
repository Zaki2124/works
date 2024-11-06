const int interval = 1000;
const float dutyRatio = 0.1f;
int onTime = 0;

void setup() {
  pinMode(2, OUTPUT);
  pinMode(3, INPUT_PULLUP);
}
  
void loop() {
  digitalWrite(2, !digitalRead(3));
  delay(10);
}
