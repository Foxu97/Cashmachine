import java.util.*

class ATM(){
    val random = Random();
    var zl20: Int = random.nextInt(1000)
    var zl50: Int = random.nextInt(1000)
    var zl100: Int = random.nextInt(1000)
    var zl200: Int = random.nextInt(1000)

    var sumInATM: Int = (20*zl20 + 50*zl50 + 100* zl100 + 200*zl200)



}