from gpiozero import LED
from time import sleep

led = LED(17)
DIT = 300
DAH = DIT * 3

message = ""
with open('message.txt', 'r') as file:
    line = file.readline()
    while line:
        message += line
        line = file.readline()

print(message)

for ch in message:
    if ch == '.':
        led.on()
        sleep(DIT)
        led.off()
        sleep(DIT)
    elif ch == '-':
        led.on()
        sleep(DAH)
        led.off()
        sleep(DAH)
    else:
        sleep(DAH*2)
