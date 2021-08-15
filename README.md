interrupt

### https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html#interrupt()

# 주의
InterruptedException을 수신할 경우 interrupted상태가 초기화 될 수 있다

### 좀 애매하긴한데 InterruptedException을 수신할 경우 interrupted상태가 초기화 될 수 있다. 메서드마다 다른듯.
### 차단(Blocking)이라는 단어도 나오는데 JVM레벨에서의 차단인지 OS레벨에서의 차단인지 의미가 약간 애매한듯. JVM레벨에서의 차단을 의미하는듯.