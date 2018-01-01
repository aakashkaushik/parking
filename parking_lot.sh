#!/bin/bash

set -e

red=`tput setaf 1`
green=`tput setaf 2`
reset=`tput sgr0`

if ! which mvn > /dev/null; then
   echo "${red}Maven not found. Please install maven to run the program${reset}"
   exit
else
	echo "${green} Building Jar ${reset}"
	mvn -U clean install
fi

echo "Choose option:\n1. Read Input from file\n2. Interactive Mode\n"

read reply
if [ "$reply" -eq 1 ]; then
	echo "${green}File location: ${reset}"
	read file_loc
	java -jar ./target/parking-1.0-SNAPSHOT.jar $file_loc
else
	echo "${green}Running in Interactive Mode ${reset}"
	java -jar ./target/parking-1.0-SNAPSHOT.jar
fi

read -p "Press any key..."