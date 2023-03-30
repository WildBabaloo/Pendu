package dti.g25.pendu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import dti.g25.pendu.presentateur.Presentateur

var lettres = emptyArray<Button>()

lateinit var tvScore: TextView

lateinit var tvLettresMots: TextView

lateinit var tvResult: TextView

val COULEUR_NORMAL = 0

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

        var btnRecommencer = findViewById(R.id.btnReinit) as Button
        btnRecommencer.setOnClickListener{presentateur.demarrer()}

    }

    override fun onClick(v : View) {
        lettres[v.id.toChar().code - 98].setBackgroundColor(COULEUR_SELECTIONNE)
        presentateur.selectionnerLettre(v.id.toChar()-1)
    }
    fun afficherEtatLettres(etat: String){
        tvLettresMots.text = etat
    }
    fun afficherScore(score: Int){
        tvScore.text = score.toString()
    }
    fun afficherReussi(){
        tvResult.text = "CONGRATS!"
    }
    fun afficherFailed(){
        tvResult.text = "YOU DIED!"
    }

    fun afficherReset(){
        tvResult.text = ""
        for(buttonLettre: Button in lettres){
            buttonLettre.setBackgroundColor(COULEUR_NORMAL)
        }
    }

}
