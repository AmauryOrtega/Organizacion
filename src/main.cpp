#include <ESP8266WiFi.h>
#include <Wire.h>

#define PCF8591 (0x90 >> 1) // Dirreccion del bus I2C 1001 0000
#define PCF8591_ADC0 0x00
#define PCF8591_ADC1 0x01
#define PCF8591_ADC2 0x02
#define PCF8591_ADC3 0x03

// Prototipos de funciones
void ADCLeer(unsigned int pin);

void setup(){
  Serial.begin(9600);
  // Pines D2(SDA GPIO 4) y D1(SCL GPIO 5)
  Wire.begin(4, 5);
}

void loop(){
  ADCLeer(PCF8591_ADC0);
  ADCLeer(PCF8591_ADC1);
  ADCLeer(PCF8591_ADC2);
  ADCLeer(PCF8591_ADC3);
  Serial.println("Repitiendov2.");
  Serial.println();
  Serial.println();
  delay(500);
}

void leerAO(){
  float lectura = analogRead(A0);
  float humedad = map(lectura, 0, 1023, 100, 0);
  Serial.print("A0:");Serial.println(lectura);
  Serial.print("Humedad: ");Serial.print(humedad);Serial.println("%");
}

void ADCLeer(unsigned int pin){
  Serial.print("ADC Lectura en ");
  Serial.println(pin);
  Wire.beginTransmission(PCF8591);
  Wire.write(pin);
  Wire.endTransmission();
  Wire.requestFrom(PCF8591, 2);
  Wire.read();  // Se omite el primero porque es el valor anterior
  Serial.print("Byte:" );
  Serial.println(Wire.read());
}
