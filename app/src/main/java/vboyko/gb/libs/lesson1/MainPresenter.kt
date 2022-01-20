package vboyko.gb.libs.lesson1

class MainPresenter(private val view: MainView) {

    enum class ButtonId {
        BUTTON1,
        BUTTON2,
        BUTTON3,
    }

    private val model = CountersModel()

    fun counterClick(buttonId: ButtonId) {
        when (buttonId) {
            ButtonId.BUTTON1 -> {
                val nextValue = model.next(0)
                view.setButtonText(buttonId, nextValue.toString())
            }
            ButtonId.BUTTON2 -> {
                val nextValue = model.next(1)
                view.setButtonText(buttonId, nextValue.toString())
            }
            ButtonId.BUTTON3 -> {
                val nextValue = model.next(2)
                view.setButtonText(buttonId, nextValue.toString())
            }
        }
    }
}