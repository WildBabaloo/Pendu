package dti.g25.pendu.modèle

class Jeu (listeDeMots: Array<String>)  {
    var lettresEssayées: CharArray = CharArray(26){' '}

    var motÀDeviner : String

    var pointage: Int = 0
        get() = field

    var nbErreurs: Int = 0
        get() = field
    var listeDeMots: Array<String>

    init {
        this.listeDeMots = listeDeMots
        motÀDeviner = this.listeDeMots[kotlin.random.Random.nextInt(this.listeDeMots.size)]
    }

    /**
     * Essaye une lettre choisi par le joueur en cliquant le bouton
     *
     *  @param lettre La lettre à essayer
     *
     * @return true si la lettre est dans le mot à trouver sinon false si ce n'est pas
     */
    fun essayerUneLettre(lettre: Char): Boolean {
        if (lettre in lettresEssayées) {
            //nbErreurs++
            return false
        }
        lettresEssayées[nbErreurs + pointage] = lettre
        val arrayMotÀDeviner = motÀDeviner.toCharArray()
        var réussiOuPas = false
        arrayMotÀDeviner.forEach { lettreMotADeviner ->
            if (lettreMotADeviner.lowercase() == lettre.lowercase()) {
                pointage++
                réussiOuPas = true
            }
        }
        if (réussiOuPas) {
            return true
        }
        nbErreurs++
        return false
    }

    /**
     * Voir si tout les lettres du mot ont été trouvé
     *
     * @return true si le joueur a gagné sinon retourne false
     */

    fun estRéussi(): Boolean{
        if(pointage >= motÀDeviner.length - 1){
            return true
        }
        return false
    }

    /**
     * Voir si le joueur a perdu
     *
     * @return true si le joueur a perdu sinon retourne false
     */

    fun estUnÉchec(): Boolean{
        if(nbErreurs >= 6){
            return true
        }
        return false
    }

    /**
     * Réinitialise le jeu
     */
    fun réinitialiser(){
        pointage = 0
        nbErreurs = 0
        lettresEssayées = CharArray(26){' '}
        motÀDeviner = this.listeDeMots[kotlin.random.Random.nextInt(this.listeDeMots.size)]
    }

    /**
     * Verfier l'état des lettres
     *
     * @return Une liste de caractères qui montre quelle lettres le joueur a trouvé sinon pas une lettres pas trouvé va être un "_"
     */

    fun étatLettres(): CharArray{
        var i: Int = 0
        var étatLettres: CharArray = CharArray(motÀDeviner.length - 1) {'_'}
        val arrayMotÀDeviner: Array<String> = motÀDeviner.map { it.toString() }.toTypedArray()
        for (lettresDevinées: Char in lettresEssayées){
            i = 0
            for(lettresMotÀDeviner: String in arrayMotÀDeviner){
                if(lettresMotÀDeviner.single().lowercase().equals((lettresDevinées.lowercase()))){
                    étatLettres.set(i, lettresDevinées)
                }
                i++
            }
        }
        return étatLettres
    }


}