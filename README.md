# replicated-kafka-dev-environment-example

An example of orchestrating a replicated kafka setup for local development using docker-compose.

The `.sh` files assume you have kafka installed locally (only for the tools) which can be done with `brew install kafka` on macOS. The commands can also be run in any of the three kafka containers using `docker-compose exec kafka1 bash` then `cd /opt/opt/bitnami/kafka/bin` to change directory to where the kafka tools are.

__NOT SUITABLE FOR PRODUCTION__
