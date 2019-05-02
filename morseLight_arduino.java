/* Final Project
 *  Morse Code Translator
 *  Arduino Light Side (Morse Code Display)
 */

int LED = 8;
int DIT = 300;
int DAH = DIT * 3;

void setup() {
  // put your setup code here, to run once:
  pinMode(LED, OUTPUT);
  Serial.begin(9600);
}

String message = "";

void loop() {

  while (!Serial.available()){}

  while(Serial.available() > 0){
    delay(10);
    char c = Serial.read();
    message += c;
  }

  Serial.println("Recieved: "+message);
  for (int i = 0; i < message.length(); i++) {
    char c = message.charAt(i);
    if (c == '.'){
      digitalWrite(LED, HIGH);
      delay(DIT);
      digitalWrite(LED, LOW);
      // Wait 1 units (DIT) after each dit
      delay(DIT);
    } else if (c == '-'){
      digitalWrite(LED, HIGH);
      delay(DAH);
      digitalWrite(LED, LOW);
      // Wait 1 units (DIT) after each dash
      delay(DIT);
    } else if (c == ' ') {
      // Wait 3 units (DAH) after each character
      delay(DAH*2);
    }
  }
  message = "";
  Serial.flush();
}
