package com.example.relicsmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

public class BagOfGreed extends CustomRelic {

    public static final String ID = "BagOfGreed";
    private static final int GOLD_AMT = 8;

    private static final Texture IMG = RelicTextureHelper.createRelicTexture(
            new Color(0.9f, 0.85f, 0.1f, 1.0f), Color.YELLOW);
    private static final Texture OUTLINE = RelicTextureHelper.createOutlineTexture(
            new Color(0.6f, 0.55f, 0.05f, 1.0f));

    public BagOfGreed() {
        super(ID, IMG, OUTLINE, RelicTier.COMMON, LandingSound.FLAT);
    }

    @Override
    public String getUpdatedDescription() {
        return "Whenever you defeat a non-minion enemy, gain #b" + GOLD_AMT + " additional Gold.";
    }

    @Override
    public void onMonsterDeath(AbstractMonster m) {
        if (m.currentHealth == 0 && !m.hasPower("Minion")) {
            flash();
            AbstractPlayer p = AbstractDungeon.player;
            p.gainGold(GOLD_AMT);
            for (int i = 0; i < GOLD_AMT; i++) {
                AbstractDungeon.effectList.add(new GainPennyEffect(m.hb.cX, m.hb.cY));
            }
        }
    }

    @Override
    public AbstractRelic makeCopy() {
        return new BagOfGreed();
    }
}
