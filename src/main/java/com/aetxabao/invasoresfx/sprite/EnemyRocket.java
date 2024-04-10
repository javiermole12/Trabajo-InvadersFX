package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.*;

/**
 * Clase que representa un enemigo tipo cohete que se mueve en línea recta hacia abajo.
 */
public class EnemyRocket extends AEnemy {

    private int ySpeed;
    Rect gameRect;

    public EnemyRocket(Rect gameRect, Image img, int TICKSxFRAME) {
        super(img, ENEMYROCKET_ROWS, ENEMYROCKET_COLS);
        this.gameRect=gameRect;
        this.x = (int) (Math.random() * (gameRect.width() - width) + gameRect.left);
        this.y = gameRect.top - height; // Aparece arriba
        this.ySpeed = ENEMYROCKET_Y_SPEED;
    }

    @Override
    public Rect getRect(){
        return new Rect(x, y, (int)(x + ENEMYROCKET_ALFA * width),(int)(y + ENEMYSHIP_ALFA * height));
    }


    @Override
    public void update() {
        y += ySpeed;

        // Si el cohete se sale de la pantalla por abajo, lo reiniciamos arriba
        if (y > getRect().bottom) {
            resetPosition();
        }
    }


    @Override
    public void draw(GraphicsContext gc) {
        int srcX = currentFrame * width;
        int srcY = 0;
        gc.drawImage(img, srcX, srcY, width, height, x, y, width, height);
    }

    private void resetPosition() {
        this.x = (int) (Math.random() * (getRect().width() - width) + getRect().left);
        this.y = getRect().top - height;
    }
}
