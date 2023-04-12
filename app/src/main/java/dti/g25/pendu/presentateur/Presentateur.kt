package dti.g25.pendu.presentateur

import dti.g25.pendu.MainActivity
import dti.g25.pendu.modele.Jeu

class Presentateur (var vue: MainActivity){

    var jeu = Jeu(listeDesMots())
        var hasStarted : Boolean = false

        /**
         * Réagit à une sélection d'une lettre
         *
         * @param lettre La lettre cliqué
         */
    fun selectionnerLettre(lettre: Char){
            if(hasStarted){
                    jeu.essayerUneLettre(lettre)
                    val lesLettres: String = jeu.etatLettres().joinToString(" ")
                    vue.changerCouleur(lettre)
                    vue.afficherEtatLettres(lesLettres)
                    vue.afficherScore(jeu.pointage)
                    vue.afficherImage(jeu.nbErreurs)
                    vue.afficherInstructions()
                    if (jeu.estReussi()){
                            vue.afficherReussi()
                            hasStarted = false
                    }
                    if (jeu.isFailed()){
                            vue.afficherFailed(jeu.motADeviner)
                            hasStarted = false
                    }
            }
    }

        /**
         * Réinitialise le jeu
         */

        fun demarrer(){
                hasStarted = true
                jeu.reinitialiser()
                val etatResetLettres = jeu.etatLettres().joinToString(" ")
                vue.afficherInstructions()
                vue.afficherEtatLettres(etatResetLettres)
                vue.afficherScore(jeu.pointage)
                vue.afficherImage(0)
                vue.afficherReset()
        }

        /**
         * Liste des mots
         */

    fun listeDesMots(): Array<String>{
        return arrayOf<String>("Baleine\n" ,
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
    }

}