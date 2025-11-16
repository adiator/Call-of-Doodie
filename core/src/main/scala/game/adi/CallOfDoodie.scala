package game.adi

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class CallOfDoodie extends Game{
    var batch:SpriteBatch = null

    override def create(): Unit = {
        batch = new SpriteBatch()
        setScreen(new GameScreen(this))
    }


    override def render(): Unit = super.render()
    override def dispose(): Unit = if(batch!=null) batch.dispose()
}