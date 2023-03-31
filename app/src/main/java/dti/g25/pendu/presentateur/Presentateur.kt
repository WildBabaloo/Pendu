package dti.g25.pendu.presentateur

import dti.g25.pendu.MainActivity
import dti.g25.pendu.modele.Jeu

class Presentateur (var vue: MainActivity){

    var jeu = Jeu(listeDesMots())

    fun selectionnerLettre(lettre: Char){
            var lesLettres: String = ""
            println(lettre)
            jeu.essayerUneLettre(lettre)
            for(lettresTrouve: Char in jeu.etatLettres()){
                    lesLettres += lettresTrouve.toString() + " "
            }
            vue.afficherEtatLettres(lesLettres)
            vue.afficherScore(jeu.pointage)
            vue.afficherImage(jeu.nbErreurs)
            if (jeu.estReussi()){
                    vue.afficherReussi()
            }
            if (jeu.isFailed()){
                    vue.afficherFailed()
            }
    }

        fun demarrer(){
                var etatResetLettres: String = ""
                jeu.reinitialiser()
                for(lettresTrouve: Char in jeu.etatLettres()){
                        etatResetLettres += lettresTrouve.toString() + " "
                }
                vue.afficherEtatLettres(etatResetLettres)
                vue.afficherScore(jeu.pointage)
                vue.afficherReset()
        }

    fun listeDesMots(): Array<String>{
        val lesMots = arrayOf<String>("Baleine\n" ,
                "Enfant\n" ,
                "Tapisserie\n" ,
                "Nuage\n" ,
                "Grenouille\n" ,
                "Plage\n" ,
                "Oiseau\n" ,
                "Crocodile\n" ,
                "Vent\n" ,
                "Canard\n" ,
                "Tournesol\n" ,
                "Pastèque\n" ,
                "Cerf\n" ,
                "Cheval\n" ,
                "Piano\n" ,
                "Moustache\n" ,
                "Montagne\n" ,
                "Feuille\n" ,
                "Papillon\n" ,
                "Bouquet\n" ,
                "Tomate\n" ,
                "Chaussure\n" ,
                "Parapluie\n" ,
                "Boule\n" ,
                "Chenille\n" ,
                "Tigre\n" ,
                "Crayon\n" ,
                "Coquillage\n" ,
                "Bateau\n" ,
                "Aigle\n" ,
                "Girafe\n" ,
                "Souris\n" ,
                "Chat\n" ,
                "Chapeau\n" ,
                "Citrouille\n" ,
                "Lune\n" ,
                "Guitare\n" ,
                "Tortue\n" ,
                "Marmotte\n" ,
                "Tuyau\n" ,
                "Cascade\n" ,
                "Baleine\n" ,
                "Papier\n" ,
                "Feu\n" ,
                "Orage\n" ,
                "Couronne\n" ,
                "Grenade\n" ,
                "Escalier\n" ,
                "Haricot\n" ,
                "Nuageux\n" ,
                "Balançoire\n" ,
                "Sourire\n" ,
                "Poisson\n" ,
                "Statue\n" ,
                "Casquette\n" ,
                "Coccinelle\n" ,
                "Vase\n" ,
                "Baleine\n" ,
                "Piano\n" ,
                "Soupe\n" ,
                "Fourmi\n" ,
                "Ours\n" ,
                "Dentelle\n" ,
                "Saumon\n" ,
                "Cactus\n" ,
                "Crabe\n" ,
                "Moustique\n" ,
                "Cendrier\n" ,
                "Plante\n" ,
                "Fleur\n" ,
                "Chien\n" ,
                "Clavier\n" ,
                "Grenouille\n" ,
                "Souffle\n" ,
                "Parfum\n" ,
                "Sapin\n" ,
                "Papaye\n" ,
                "Enfant\n" ,
                "Statue")

        return lesMots
    }

}