#!/bin/sh
cd ../
git pull
sudo mvn clean compile package
cd ./target
sudo ./launcher.sh