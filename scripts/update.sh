#!/bin/sh
sleep 5
sudo pkill -f 'java -jar'
sleep 5
cd ../
sudo -u pi git pull
sudo mvn clean compile package
cd ./target
sudo chmod 744 ./launcher.sh
sleep 5
sudo ./launcher.sh