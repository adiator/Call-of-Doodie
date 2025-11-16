package game.adi

import com.badlogic.gdx.{Gdx, Input}
import com.badlogic.gdx.graphics.{OrthographicCamera, Texture}
import com.badlogic.gdx.graphics.g2d.{Batch, Sprite}
import com.badlogic.gdx.math.{MathUtils, Vector2, Vector3}

class Player extends GameEntity(0.1) {
    private val speed = 400
    private var mousePos:Vector3 = new Vector3()
    private var camera:OrthographicCamera = _

    override def act(v: Float): Unit = {
        super.act(v)

        rotate()
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            move("d", v)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            move("a", v)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            move("w", v)
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            move("s", v)
        }
    }
    def setCam(cam:OrthographicCamera):Unit = {
        camera = cam
    }
    private def move(dir: String, delta: Float): Unit = {

        var dx = 0f
        var dy = 0f

        dir match {
            case "w" =>
                dy = speed * delta
            case "s" =>
                dy = -speed * delta
            case "a" =>
                dx = -speed * delta
            case "d" =>
                dx = speed * delta
        }

        moveBy(dx, dy)
    }

    private def rotate(): Unit = {
        if (camera != null) {
            mousePos = camera.unproject(new Vector3(Gdx.input.getX,  Gdx.input.getY, 0))

            val centerX = getX + getWidth / 2
            val centerY = getY + getHeight / 2

            val xdiff = mousePos.x-centerX
            val ydiff = mousePos.y-centerY

            val angle = MathUtils.atan2(ydiff, xdiff) * MathUtils.radiansToDegrees - 90

            setRotation(angle)
        }

    }

}