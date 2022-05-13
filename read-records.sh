#!/bin/bash
set -x #echo on
kafka-console-consumer --bootstrap-server localhost:9092 --topic mytopic --from-beginning