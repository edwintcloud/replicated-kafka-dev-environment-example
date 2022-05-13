#!/bin/bash
set -x #echo on
kafka-topics --bootstrap-server localhost:9093 --topic mytopic --partitions 3 --replication-factor 3 --create
kafka-topics --bootstrap-server localhost:9093 --topic mytopic  --describe