#!/bin/bash

set -e

# recipe
mkdir -p ../meta-lerobot/recipes-lerobot/lerobot/files/certs/

cp ca.crt ../meta-lerobot/recipes-lerobot/lerobot/files/certs/

cp client_control* ../meta-lerobot/recipes-lerobot/lerobot/files/certs/
cp client_dashboard* ../meta-lerobot/recipes-lerobot/lerobot/files/certs/
cp client_follower* ../meta-lerobot/recipes-lerobot/lerobot/files/certs/
cp client_leader* ../meta-lerobot/recipes-lerobot/lerobot/files/certs/
cp client_system_state_publisher.* ../meta-lerobot/recipes-lerobot/lerobot/files/certs/


# mosquitto
mkdir -p ../mosquitto/certs/

cp ca.crt ../mosquitto/certs/

cp server.crt ../mosquitto/certs/
cp server.key ../mosquitto/certs/
cp server_7_27.crt ../mosquitto/certs/
cp server_7_27.key ../mosquitto/certs/

cp client_java* ../mosquitto/certs/

cp truststore.p12 ../mosquitto/certs/
