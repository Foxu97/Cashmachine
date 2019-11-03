class User(val name: String, var cash: Int){
    public fun addToBalance(i: Int){this.cash += i}
}