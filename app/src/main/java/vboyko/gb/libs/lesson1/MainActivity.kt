package vboyko.gb.libs.lesson1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import vboyko.gb.libs.lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mainBinding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val makeListener =
            { buttonId: MainPresenter.ButtonId -> View.OnClickListener { presenter.counterClick(buttonId) } }
        mainBinding.btnCounter1.setOnClickListener(makeListener(MainPresenter.ButtonId.BUTTON1))
        mainBinding.btnCounter2.setOnClickListener(makeListener(MainPresenter.ButtonId.BUTTON2))
        mainBinding.btnCounter3.setOnClickListener(makeListener(MainPresenter.ButtonId.BUTTON3))
    }

    override fun setButtonText(buttonId: MainPresenter.ButtonId, text: String) {
        when (buttonId) {
            MainPresenter.ButtonId.BUTTON1 -> mainBinding.btnCounter1.text = text
            MainPresenter.ButtonId.BUTTON2 -> mainBinding.btnCounter2.text = text
            MainPresenter.ButtonId.BUTTON3 -> mainBinding.btnCounter3.text = text
        }
    }
}