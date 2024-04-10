package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.ENEMYBARRIER_COLS;
import static com.aetxabao.invasoresfx.game.AppConsts.ENEMYBARRIER_ROWS;

public class EnemyBarrier extends AEnemy {
    private int shieldStrength;

    public EnemyBarrier(int img, Rect rows, Image cols, int shieldStrength) {
        super(cols, ENEMYBARRIER_ROWS, ENEMYBARRIER_COLS);
        this.shieldStrength = shieldStrength;
    }

    @Override
    public void update() {
        // Aquí puedes agregar la lógica de actualización específica para EnemyBarrier
    }

    public void reduceShieldStrength(int amount) {
        shieldStrength -= amount;
        if (shieldStrength < 0) {
            shieldStrength = 0;
        }
    }

    public int getShieldStrength() {
        return shieldStrength;
    }
}
