package dti.g25.pendu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import dti.g25.pendu.presentateur.Presentateur

// Les lettres

var lettres = emptyArray<Button>()

lateinit var tvScore: TextView

lateinit var tvLettresMots: TextView

lateinit var tvResult: TextView

lateinit var imagePendu: ImageView

lateinit var btnRecommencer : Button

// Couleurs des boutons
val COULEUR_NORMAL = 0xFF5b39c6.toInt()
val COULEUR_SELECTIONNE = 0xFF808080.toInt()

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val presentateur = Presentateur(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for(i in 65 .. 90){
            val resID = resources.getIdentifier("btn${i.toChar()}", "id", packageName)
            val lettre = findViewById(resID) as Button
            lettres += lettre
            lettre.setOnClickListener{onClick(lettre)}
        }
        tvScore = findViewById(R.id.tvScore)
        tvLettresMots = findViewById(R.id.tvLettresMots)
        tvResult = findViewById(R.id.tvResult)
        imagePendu = findViewById(R.id.imgPendu)

        btnRecommencer = findViewById(R.id.btnReinit) as Button
        btnRecommencer.setOnClickListener{presentateur.demarrer()}

    }

    /**
     * Écouteur des boutons alphabétisés
     *
     * @param v Le bouton cliqué
     */

    override fun onClick(v : View) {
        var lettreButton: Button = v as Button
        var buttonText : String = lettreButton.text.toString()
        presentateur.selectionnerLettre(buttonText.single())
    }

    /**
     * Changer la couleur à gris quand on clique sur une lettre
     *
     * @param lettre Le lettre qu'on a cliqué
     */
    fun changerCouleur(lettre : Char){
        lettres[lettre.code - 65].setBackgroundColor(COULEUR_SELECTIONNE)
    }

    /**
     * Afficher l'état des lettres
     *
     * @param clic L'état des lettres (Such creative! WOW!)
     */
    fun afficherEtatLettres(etat: String){
        tvLettresMots.text = etat
    }

    /**
     * Afficher le score
     *
     * @param score Le score (NO WAY!)
     */
    fun afficherScore(score: Int){
        tvScore.text = score.toString()
    }

    /**
     * Afficher les instructions
     */
    fun afficherInstructions(){
        tvResult.text = "Devinez ce mot :"
    }

    /**
     * Afficher la réussite (On god)
     */
    fun afficherReussi(){
        tvResult.text = "CONGRATS!"
    }

    /**
     * Afficher L'INCOMPÉTENCE DU JOUEUR DE NE PAS DEVINER LE MOT HAHAHAHAHHAHAHAHAHA
     */
    fun afficherFailed(motADeviner : String){
        tvResult.text = "SKILL ISSUE!"
        tvLettresMots.text = "Le mot était : " +motADeviner
    }

    /**
     * Reset les couleurs du bouton
     */

    fun afficherReset(){
        btnRecommencer.text = "RÉINITIALISER"
        for(buttonLettre: Button in lettres){
            buttonLettre.setBackgroundColor(COULEUR_NORMAL)
        }
    }

    /**
     * HAAAAAAAAAAAANNNNNNNNNNNNNNNNNNNNNGGGGGGGGGGGGGGGGGGGGGGMAN1 (Afficher les images du hangman)
     */
    fun afficherImage(numero: Int){
        var imageValue = "hangman$numero"
        var id: Int = resources.getIdentifier(imageValue, "drawable", packageName)
        imagePendu.setImageResource(id)
    }

}
