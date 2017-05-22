#include <ESP8266WiFi.h>
#include <Wire.h>

#define PCF8591 (0x90 >> 1) // Dirreccion del bus I2C 1001 0000
#define PCF8591_ADC0 0x00
#define PCF8591_ADC1 0x01
#define PCF8591_ADC2 0x02
#define PCF8591_ADC3 0x03

// Prototipos de funciones
void ADCLeer(unsigned int pin);
int valorPin(unsigned int pin);
void setup(){
  Serial.begin(9600);
  // Pines D2(SDA GPIO 4) y D1(SCL GPIO 5)
  Wire.begin(4, 5);
}

void loop(){
  // ADCLeer(PCF8591_ADC0);
  // ADCLeer(PCF8591_ADC1);
  // ADCLeer(PCF8591_ADC2);
  // ADCLeer(PCF8591_ADC3);
  // Serial.println("Repitiendov2.");
  // Serial.println();
  // Serial.println();
  Serial.print(valorPin(PCF8591_ADC0));
  Serial.print(";");
  Serial.print(valorPin(PCF8591_ADC1));
  Serial.print(";");
  Serial.print(valorPin(PCF8591_ADC2));
  Serial.print(";");
  Serial.print(valorPin(PCF8591_ADC3));
  Serial.println();
  delay(500);
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

int valorPin(unsigned int pin){
    Wire.beginTransmission(PCF8591);
    Wire.write(pin);
    Wire.endTransmission();
    Wire.requestFrom(PCF8591, 2);
    Wire.read();  // Se omite el primero porque es el valor anterior
    return Wire.read();
}
