fun main() {
    print("Input bilangan = ")
    var bil = Integer.valueOf(readLine())

    var x = bil
    var i = 0
    while(i<5){
        bil += x
        if(bil % 2 == 0 || bil % 3 == 0){
            print(bil)
            print(" ")
            i++
        }
    }
}