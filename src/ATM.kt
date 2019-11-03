import java.util.*

class ATM{
    val random = Random();

    private var sumInATM = 0;
    private var denomination = mutableMapOf(
            200 to random.nextInt(100),
            100 to random.nextInt(100),
            50 to random.nextInt(1000),
            20 to random.nextInt(1000),
            10 to random.nextInt(1000)
    )
    private fun getSum():Int {return sumInATM}

    public fun getSumInATM(): Int {
        return sumInATM
    }

    public fun sumInBank():Int{
        sumInATM = 0
        for (i in denomination) {
            sumInATM += i.key * i.value
        }
        return sumInATM
    }

    public fun cashOut(user: User, cashToOut: Int):String {
        if(sumInATM >= cashToOut && cashToOut <= user.cash)
        {
            var r = cashToOut
            for(i in denomination) {
                var v = i.value
                while (sumInATM > 0 && r >= i.key && v>0 && r > 0) {
                    r -= i.key //zmniejsza cashToOut o wydawaną sumę
                    v -= 1
                    sumInATM -= i.key
                    denomination[i.key] = i.value-1 //subtract from ATM

                    user.cash -= i.key
                }
            }
            user.addToBalance(r)
            return("Wypłata kwoty ${cashToOut} dla użytkownika ${user.name} zakończona sukcesem! \nStan konta po wypłacie: ${user.cash}. \nDostepne nominaly po wyplacie:${denomination}." + denomination)
        }
        else{
            return "Nie mozna wyplacic zadanej kwoty"
        }
    }

    constructor(){
        sumInBank()
        for (nom in denomination){
            println("Nominal ${nom.key}, ilosc: ${nom.value}")
        }
        println("pieniazkow w atm: ${sumInATM}zl")
    }

}