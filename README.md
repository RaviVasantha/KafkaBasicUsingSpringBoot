In the first command prompt window, navigate to the Kafka installation directory:

cd "C:\Program Files\kafka_2.12-3.7.0"
**************************************************************
Start Zookeeper server by running the following command

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

*******************************************************************
In the second command prompt window, navigate to the Kafka installation directory again

cd "C:\Program Files\kafka_2.12-3.7.0"

*****************************************************************
Start Kafka server by running the following command

.\bin\windows\kafka-server-start.bat .\config\server.properties

********************************************************************
Create a Topic:
Open a new command prompt window and navigate to the Kafka installation directory.
Run the following command to create a Kafka topic named test-topic

.\bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092
*****************************************************************
Produce Messages:

Open another command prompt window and navigate to the Kafka installation directory.
Run the following command to start a console producer and produce messages to the test-topic:

.\bin\windows\kafka-console-producer.bat --topic test-topic --bootstrap-server localhost:9092

**********************************************************************
Consume Messages:

Open another command prompt window and navigate to the Kafka installation directory.
Run the following command to start a console consumer and consume messages from the test-topic

.\bin\windows\kafka-console-consumer.bat --topic test-topic --from-beginning --bootstrap-server localhost:9092

