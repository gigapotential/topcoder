javac -cp ".:jars/*" TestFlowerGarden.java TestBadNeighbors.java TestAvoidRoads.java TestChessMetric.java TestFoxAndMp3Easy.java TestUnsortedSequence.java TestTheEncryptionDivTwo.java TestAutoLoan.java TestMazeWanderingEasy.java
time java -cp ".:jars/*" org.junit.runner.JUnitCore TestFlowerGarden TestBadNeighbors TestAvoidRoads TestChessMetric TestFoxAndMp3Easy TestUnsortedSequence TestTheEncryptionDivTwo TestAutoLoan TestMazeWanderingEasy
./clean.sh
