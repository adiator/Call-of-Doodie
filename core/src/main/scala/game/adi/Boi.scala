package game.adi

import com.badlogic.gdx.math.{MathUtils, Vector2}

class Boi extends GameEntity(0.3) {
    private var player: Player = _
    private val speed = 200
    private var clampx: Int = _
    private var clampy: Int = _
    private val center = new Vector2()
    private var newX: Float = _
    private var newY: Float = _


    def turnToPlayer(p: Player): Unit = player = p

    override def act(delta: Float): Unit = {
        super.act(delta)
        rotate(player)
        move(delta)
    }


    private def move(delta: Float): Unit = {
        val rotation = getRotation * MathUtils.degreesToRadians


        var dx = 0f
        var dy = 0f

        dx = -MathUtils.sin(rotation) * speed * delta
        dy = MathUtils.cos(rotation) * speed * delta
        newX = MathUtils.clamp(getX + dx, center.x - clampx, center.x + clampx)
        newY = MathUtils.clamp(getY + dy, center.y - clampy, center.y + clampy)

        setPosition(newX, newY)
    }

    private def rotate(player: Player): Unit = {
        val centerX = getX + getWidth / 2
        val centerY = getY + getHeight / 2
        val playerX = player.getX() + player.getWidth / 2
        val playerY = player.getY() + player.getHeight / 2

        val xdiff = centerX - playerX
        val ydiff = centerY - playerY

        val angle = MathUtils.atan2(ydiff, xdiff) * MathUtils.radiansToDegrees + 90

        setRotation(angle)
    }

    override def setPosition(x: Float, y: Float): Unit = {
        super.setPosition(x, y)
    }

    def setCenter(x: Float, y: Float): Unit = {
        super.setPosition(x, y)
        center.x = x
        center.y = y

    }

    def clamp(x: Int, y: Int): Unit = {
        clampx = x
        clampy = y
    }
}
