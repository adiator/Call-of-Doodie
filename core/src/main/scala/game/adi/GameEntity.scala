package game.adi

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.scenes.scene2d.Actor

class GameEntity(scale:Float) extends Actor{
    private var sprite:Sprite = _

    def initSprite(t: Texture): Unit = {
        sprite = new Sprite(t)
        sprite.setSize(t.getWidth * scale, t.getHeight * scale)
        setSize(sprite.getWidth, sprite.getHeight)
    }

    override def draw(batch: Batch, parentAlpha: Float): Unit = {
        sprite.setPosition(getX, getY)
        sprite.setRotation(getRotation)
        sprite.setScale(getScaleX, getScaleY)
        sprite.setColor(getColor)
        sprite.setOriginCenter()
        sprite.draw(batch, parentAlpha)
    }

    override def act(delta: Float): Unit = super.act(delta)
}