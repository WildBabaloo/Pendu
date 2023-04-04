package dti.g25.pendu.modele

import org.junit.Test

class JeuTest {

    @Test
    fun testEssayerLettre(){
        var valeurObservee: Boolean
        val valeurAttendue = true
        var jeuTest = Jeu(listeMots())

        valeurObservee = jeuTest.essayerUneLettre('A')
        println("Le mot est : " +jeuTest.motADeviner)
        if(valeurObservee == valeurAttendue){
            println("SUCCESS!")
        }
        else {
            println("ERREUR: attendu: "+valeurAttendue+" observé: "+valeurObservee)
        }

    }

    @Test
    fun testEstReussi(){
        var valeurObservee: Boolean
        val valeurAttendue = true
        var jeuTest = Jeu(listeMots())

        valeurObservee = jeuTest.estReussi()
        if(valeurObservee == valeurAttendue){
            println("SUCCESS!")
        }
        else {
            println("ERREUR: attendu: "+valeurAttendue+" observé: "+valeurObservee)
        }

    }

    @Test
    fun testIsFailed(){
        var valeurObservee: Boolean
        val valeurAttendue = true
        var jeuTest = Jeu(listeMots())

        valeurObservee = jeuTest.isFailed()
        if(valeurObservee == valeurAttendue){
            println("SUCCESS!")
        }
        else {
            println("ERREUR: attendu: "+valeurAttendue+" observé: "+valeurObservee)
        }

    }

    @Test
    fun testEtatLettres(){
        lateinit var valeurObservee: CharArray
        //val valeurAttendue = true
        var jeuTest = Jeu(listeMots())
        jeuTest.essayerUneLettre('E')
        println("Le mot est : " +jeuTest.motADeviner)
        valeurObservee = jeuTest.etatLettres()
        for (valeur: Char in valeurObservee){
            print(valeur)
        }

    }

    fun listeMots(): Array<String>{
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
        return listeMots
    }
    fun main(){
        testEssayerLettre()
        testEstReussi()
        testIsFailed()
    }
}
