package game.adi

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.{Color, OrthographicCamera, Texture}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.ScreenViewport


class GameScreen(game: CallOfDoodie) extends Screen {
    var playerImg: Texture = null
    var player: Player = _
    var stage: Stage = _
    var boi: Boi =_
    var boi2:Boi =_
    private var camera: OrthographicCamera = _




    override def show(): Unit = {

        stage = new Stage(new ScreenViewport())
        camera = stage.getCamera.asInstanceOf[OrthographicCamera]

        playerImg = new Texture("player.png")
        player = new Player()
        player.initSprite(playerImg)
        player.setPosition(200, 200)
        player.setCam(camera)

        boi = new Boi()
        boi.initSprite(new Texture("boi.png"))
        boi.turnToPlayer(player)
        boi.setCenter(200, 500)
        boi.clamp(100, 100)

        boi2 = new Boi()
        boi2.initSprite(new Texture("boi.png"))
        boi2.turnToPlayer(player)
        boi2.setCenter(500, 500)
        boi2.clamp(200, 200)


        stage.addActor(player)
        stage.addActor(boi)
        stage.addActor(boi2)
        Gdx.input.setInputProcessor(stage)

    }


    private def draw(): Unit = {
        ScreenUtils.clear(Color.BLACK)
        stage.act()
        stage.draw()
        camera.update()
    }
    private def updateCameraPosition():Unit ={
        camera.position.x = player.getX
        camera.position.y = player.getY
    }

    override def render(v: Float): Unit = {
        draw()
        updateCameraPosition()
    }


    override def resize(width: Int, height: Int): Unit = {
        stage.getViewport.update(width, height, true)
    }

    override def hide(): Unit = {}

    override def pause(): Unit = {}

    override def resume(): Unit = {}

    override def dispose(): Unit = {
        if (playerImg != null) playerImg.dispose()
        if (stage != null) stage.dispose()
    }

}
