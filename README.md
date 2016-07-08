# Pi API Robot

## Install
```
    git clone git@gitlab.com:tfSheol/pi-api-robot.git
    sudo mvn clean compile package
    sudo chmod 744 ./scripts/update.sh
    sudo chmod 744 ./target/launcher.sh
    cd ./target
    sudo ./launcher.sh
```

## OUTPUT

### LED
* 7 : LED 1
* 0 : LED 2
* 2 : LED 3
* 21 : LED 4

### MOTOR
* 24 : Motor 1 +
* 25 : Motor 2 +
* 28 : Motor 1 -
* 29 : Motor 2 -