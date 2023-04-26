package dti.g25.pendu.test

import dti.g25.pendu.modèle.Jeu
import org.junit.Test

class JeuTest {

    @Test
    fun testEssayerLettre(){
        var valeurObservée: Boolean
        val valeurAttendue = true
        var jeuTest = Jeu(listeMots())

        valeurObservée = jeuTest.essayerUneLettre('A')
        println("Le mot est : " +jeuTest.motÀDeviner)
        if(valeurObservée == valeurAttendue){
            println("SUCCESS!")
        }
        else {
            println("ERREUR: attendu: "+valeurAttendue+" observé: "+valeurObservée)
        }

    }

    @Test
    fun testEstReussi(){
        var valeurObservée: Boolean
        val valeurAttendue = true
        var jeuTest = Jeu(listeMots())

        valeurObservée = jeuTest.estRéussi()
        if(valeurObservée == valeurAttendue){
            println("SUCCESS!")
        }
        else {
            println("ERREUR: attendu: "+valeurAttendue+" observé: "+valeurObservée)
        }

    }

    @Test
    fun testEstUnÉchec(){
        var valeurObservée: Boolean
        val valeurAttendue = true
        var jeuTest = Jeu(listeMots())

        valeurObservée = jeuTest.estUnÉchec()
        if(valeurObservée == valeurAttendue){
            println("SUCCESS!")
        }
        else {
            println("ERREUR: attendu: "+valeurAttendue+" observé: "+valeurObservée)
        }

    }

    @Test
    fun testÉtatLettres(){
        lateinit var valeurObservée: CharArray
        //val valeurAttendue = true
        var jeuTest = Jeu(listeMots())
        jeuTest.essayerUneLettre('E')
        println("Le mot est : " +jeuTest.motÀDeviner)
        valeurObservée = jeuTest.étatLettres()
        for (valeur: Char in valeurObservée){
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
}
