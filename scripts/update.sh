#!/bin/sh
sudo pkill -f 'java -jar'
cd ../
sudo -u pi git pull
sudo mvn clean compile package
cd ./target
sudo chmod 744 ./launcher.sh
sudo ./launcher.sh