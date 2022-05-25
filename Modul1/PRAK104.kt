class router{
    fun jenisRouter(){
        println("1. Berdasarkan Mekanisme\n2. Berdasarkan Pengaplikasian")
        print("Pilih Jenis : ")
        val pilihJenis = Integer.valueOf(readLine())
        if(pilihJenis == 1){
            println("1. Router Statis\n2. Router Dinamis\n3. Wireless Router")
        }else if(pilihJenis == 2){
            println("1. Router Hardware\n2. Router Software\n3. Router PC")
        }else{
            println("Pilihan tidak ditemukan!")
        }
    }
    fun konfigurasiRouter(){
        println("1. Konfigurasi Hostname\n2. Konfigurasi Password \n3. Perintah show")
        print("Pilih Konfigurasi : ")
        val pilihKonfig = Integer.valueOf(readLine())
        if(pilihKonfig == 1){
            println("CLI command mode\n1. Konfigurasi Hostname\n'Hostname Bela'")
        }else if(pilihKonfig == 2){
            println("2. Konfigurasi Password\na. Password Console\nb. Password Vty")
            print("Pilih Konfigurasi Password : ")
            val pass = readLine()
            if("$pass" == "a"){
                println("CLI command mode\n'line console 0'\n'login'\n'password 12345'")
            }else if("$pass" == "b"){
                println("CLI command mode\n'line vty 0 4'\n'login'\n'password 12345'")
            }else{
                println("Pilihan tidak ditemukan!")
            }
        }else if(pilihKonfig == 3){
            println("3. Perintah show\nCLI command mode\n'show interface'\n'show controllers serial'\n'show clock'\n'show hosts'\n'show users'\n'show arp'")
        }
        else{
            println("Pilihan tidak ditemukan!")
        }
    }
}
fun main(){
    val tentangRouter = router()
    tentangRouter.konfigurasiRouter()
}