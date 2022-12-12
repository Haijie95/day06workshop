javac -sourcepath src -d classes src/day06/*.java
java -cp classes day06.ListServer 8080
java -cp classes day06.ListClient 10 100 localhost 8080