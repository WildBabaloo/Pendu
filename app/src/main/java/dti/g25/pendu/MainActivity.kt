package dti.g25.pendu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import dti.g25.pendu.presentateur.Presentateur

var lettres = emptyArray<Button>()

lateinit var tvScore: TextView

lateinit var tvLettresMots: TextView

lateinit var tvResult: TextView

lateinit var imagePendu: ImageView

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

        var btnRecommencer = findViewById(R.id.btnReinit) as Button
        btnRecommencer.setOnClickListener{presentateur.demarrer()}

    }

    override fun onClick(v : View) {
        var lettreButton: Button = v as Button
        var buttonText : String = lettreButton.text.toString()
        presentateur.selectionnerLettre(buttonText.single())
    }
    fun changerCouleur(lettre : Char){
        lettres[lettre.code - 65].setBackgroundColor(COULEUR_SELECTIONNE)
    }
    fun afficherEtatLettres(etat: String){
        tvLettresMots.text = etat
    }
    fun afficherScore(score: Int){
        tvScore.text = score.toString()
    }
    fun afficherInstructions(){
        tvResult.text = "Devinez ce mot :"
    }
    fun afficherReussi(){
        tvResult.text = "CONGRATS!"
    }
    fun afficherFailed(motADeviner : String){
        tvResult.text = "YOU DIED!"
        tvLettresMots.text = "Le mot était : " +motADeviner
    }

    fun afficherReset(){
        for(buttonLettre: Button in lettres){
            buttonLettre.setBackgroundColor(COULEUR_NORMAL)
        }
    }

    fun afficherImage(numero: Int){
        var imageValue = "hangman$numero"
        var id: Int = resources.getIdentifier(imageValue, "drawable", packageName)
        imagePendu.setImageResource(id)
    }

}
