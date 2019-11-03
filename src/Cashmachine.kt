import java.io.File;
import java.util.Scanner;
val INFINITY: Int = 2147483647;
val users: MutableList<User> = mutableListOf<User>()
fun importUsers(){
    File("Users.txt").forEachLine(Charsets.UTF_8) {
        var user = it.split(":");
        val newUser = User(user[0], user[1].trim().toInt());
        users.add(newUser);
    }
}

fun main(args: Array<String>) {
    var cashMachine = ATM();
    val input = Scanner(System.`in`)
    var amount: Int? = null
    importUsers()

    println("Podaj nazwe uzytkownika");
    val userName = readLine()?.trim();

    var isUser = users.filter { it.name.toLowerCase() == userName?.toLowerCase() }
    if(isUser.count() != 0){
        val fetchedUser = isUser[0];
        println("Saldo uzyktownika ${fetchedUser.name} wynosi: ${fetchedUser.cash}")
        println("Podaj kwote do wyplaty");
        amount = input.nextInt()
        while(amount == null || (amount > fetchedUser.cash && amount < cashMachine.getSumInATM())){
            if(amount == null || amount > fetchedUser.cash){
                println("Podana kwota jest wieksza niz twoj stan konta, podaj nowa kwote");
                amount = input.nextInt()
            }
            else if(amount == null || amount < cashMachine.getSumInATM()){
                println("Za malo pieniedzy w bankomacie");
                amount = input.nextInt()
            }
            else {
                println("Something went wrong")
//                println("Trwa wyplacanie pieniedzy")
//                cashMachine.cashOut(fetchedUser, amount)
            }
        }
            println("Trwa wyplacanie pieniedzy")
             println(cashMachine.cashOut(fetchedUser, amount))
    }
    else{
        println("Nie znaleziono takiego uzytkownika");
    }

}