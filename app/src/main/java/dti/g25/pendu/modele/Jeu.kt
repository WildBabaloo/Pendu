package dti.g25.pendu.modele

class Jeu (listeDeMots: Array<String>)  {
    var lettresEssayees: CharArray = CharArray(26){' '}

    var motADeviner : String

    var pointage: Int = 0
        get() = field

    var nbErreurs: Int = 0
        get() = field
    var listeDeMots: Array<String>

    init {
        this.listeDeMots = listeDeMots
        motADeviner = this.listeDeMots[kotlin.random.Random.nextInt(this.listeDeMots.size)]
        println(motADeviner)
    }

    fun essayerUneLettre(lettre: Char): Boolean{
        var reussiOrNo: Boolean = false
        lettresEssayees.set(nbErreurs+pointage, lettre)
        var arrayMotADeviner: Array<String> = motADeviner.map { it.toString() }.toTypedArray()
        for(lettresMotADeviner: String in arrayMotADeviner){
            if(lettresMotADeviner.single().lowercase().equals((lettre.lowercase()))){
                pointage+=1
                reussiOrNo = true
            }
        }
        if(reussiOrNo){
            return true
        } else {
            nbErreurs+=1
            return false
        }
    }

    fun estReussi(): Boolean{
        if(pointage >= motADeviner.length - 1){
            return true
        }
        return false
    }

    fun isFailed(): Boolean{
        if(nbErreurs >= 9){
            return true
        }
        return false
    }

    fun reinitialiser(){
        pointage = 0
        nbErreurs = 0
        lettresEssayees = CharArray(26){' '}
        motADeviner = this.listeDeMots[kotlin.random.Random.nextInt(this.listeDeMots.size)]
        println(motADeviner)
    }


    fun etatLettres(): CharArray{
        var i: Int = 0
        var pendu: CharArray = CharArray(motADeviner.length - 1) {'_'}
        var arrayMotADeviner: Array<String> = motADeviner.map { it.toString() }.toTypedArray()
        for (lettresDevines: Char in lettresEssayees){
            i = 0
            for(lettresMotADeviner: String in arrayMotADeviner){
                if(lettresMotADeviner.single().lowercase().equals((lettresDevines.lowercase()))){
                    pendu.set(i, lettresDevines)
                }
                i++
            }
        }
        return pendu
    }


}

fun main() {
    val listeMots = arrayOf<String>("Serendipity\n",
            "Pernicious\n",
            "Mellifluous\n",
            "Quixotic\n",
            "Furtive\n",
            "Supercilious\n",
            "Ebullient\n",
            "Voracious\n",
            "Cacophony\n",
            "Inscrutable")
    var unJeu: Jeu = Jeu(listeMots)
    print(unJeu.essayerUneLettre('E'))
    println(unJeu.essayerUneLettre('a'))
    println(unJeu.essayerUneLettre('t'))
    println(unJeu.essayerUneLettre('s'))
    unJeu.reinitialiser()
    println(unJeu.essayerUneLettre('M'))
    println(unJeu.essayerUneLettre('O'))
    println(unJeu.essayerUneLettre('p'))
    println(unJeu.essayerUneLettre('e'))
    var result: CharArray = unJeu.etatLettres()
    for (lettre: Char in result){
        print(lettre)
    }
}