javac -cp ".:jars/*" TestFlowerGarden.java TestBadNeighbors.java TestAvoidRoads.java TestChessMetric.java
time java -cp ".:jars/*" org.junit.runner.JUnitCore TestFlowerGarden TestBadNeighbors TestAvoidRoads TestChessMetric
./clean.sh
