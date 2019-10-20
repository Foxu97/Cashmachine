import org.jetbrains.annotations.Mutable
import java.io.File;
import java.util.Scanner;
val INFINITY: Int = 2147483647;
val users: MutableList<User> = mutableListOf<User>()
fun importUsers(){
    File("Users.txt").forEachLine(Charsets.UTF_8) {
        var user = it.split(":");
        val newUser = User(user[0], user[1].toDouble());
        users.add(newUser);
        //users.forEach{println(it.name); println(it.cash)}
    }
}

fun giveMoney(amountToGive: Int){
// to do 
}

fun main(args: Array<String>) {
    var cashMachine = ATM();
    println("W bankomacie jest " + cashMachine.sumInATM + "zl")
    val input = Scanner(System.`in`)
    var amount: Double? = null
    importUsers()

   // println(userName);

    println("Podaj nazwe uzytkownika");
    val userName = readLine();

    var isUser = users.filter { it.name.toLowerCase() == userName?.toLowerCase() }
    if(isUser.count() != 0){
        val fetchedUser = isUser[0];
        println("Podaj kwote do wyplaty");
        amount = input.nextDouble()
        while(amount == null || (amount > fetchedUser.cash && amount < cashMachine.sumInATM)){
            if(amount == null || amount > fetchedUser.cash){
                println("Podana kwota jest wieksza niz twoj stan konta, podaj nowa kwote");
                amount = input.nextDouble()
            }
            else if(amount == null || amount < cashMachine.sumInATM){
                println("Za malo pieniedzy w bankomacie");
                amount = input.nextDouble()
            }
            else {

            }
        }
        println("Kwota do wyplacenia" + amount)
    }
    else{
        println("Nie znaleziono takiego uzytkownika");
    }




    //println(amount)

}