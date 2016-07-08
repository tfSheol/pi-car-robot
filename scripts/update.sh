#!/bin/sh
sleep 5
sudo pkill -f 'java -jar'
sleep 5
cd ../
sudo rm -rf ./target
sudo -u pi git pull
sleep 10
sudo -u pi mvn clean compile package
cd ./target
sudo chmod 744 ./launcher.sh
sleep 5
sudo ./launcher.sh