package com.example.relicsmod;

import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.example.relicsmod.relics.BagOfGreed;
import com.example.relicsmod.relics.HourglassOfTime;
import com.example.relicsmod.relics.LuckyDice;
import com.example.relicsmod.relics.PhoenixFeather;
import com.example.relicsmod.relics.TalismanOfVengeance;
import com.megacrit.cardcrawl.localization.RelicStrings;

@SpireInitializer
public class RelicsMod implements EditRelicsSubscriber, EditStringsSubscriber {

    public RelicsMod() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new RelicsMod();
    }

    @Override
    public void receiveEditStrings() {
        String relicStrings = "{"
            + "\"BagOfGreed\": {"
            + "\"NAME\": \"Bag of Greed\","
            + "\"FLAVOR\": \"A mysterious bag that seems to attract coins to its owner.\","
            + "\"DESCRIPTIONS\": [\"Whenever you defeat a non-minion enemy, gain #b8 additional Gold.\"]"
            + "},"
            + "\"HourglassOfTime\": {"
            + "\"NAME\": \"Hourglass of Time\","
            + "\"FLAVOR\": \"The sands flow endlessly, carrying both power and decay.\","
            + "\"DESCRIPTIONS\": [\"At the start of each turn, gain [E]. NL At the end of your turn, lose #b1 HP.\"]"
            + "},"
            + "\"LuckyDice\": {"
            + "\"NAME\": \"Lucky Dice\","
            + "\"FLAVOR\": \"Fortune favors the bold \\u2014 are you feeling lucky?\","
            + "\"DESCRIPTIONS\": [\"At the start of each combat, randomly gain #b1 Strength, #b1 Dexterity, or #b2 Regenerate.\"]"
            + "},"
            + "\"PhoenixFeather\": {"
            + "\"NAME\": \"Phoenix Feather\","
            + "\"FLAVOR\": \"A brilliant feather that still radiates the warmth of rebirth.\","
            + "\"DESCRIPTIONS\": [\"At the start of each combat, if your HP is below #b50%, heal #b25% of your Max HP.\"]"
            + "},"
            + "\"TalismanOfVengeance\": {"
            + "\"NAME\": \"Talisman of Vengeance\","
            + "\"FLAVOR\": \"An ancient charm that retaliates against those who harm its bearer.\","
            + "\"DESCRIPTIONS\": [\"Whenever you lose HP from an enemy's attack, gain #b3 Block.\"]"
            + "}"
            + "}";

        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelic(new BagOfGreed(), RelicType.SHARED);
        BaseMod.addRelic(new HourglassOfTime(), RelicType.SHARED);
        BaseMod.addRelic(new LuckyDice(), RelicType.SHARED);
        BaseMod.addRelic(new PhoenixFeather(), RelicType.SHARED);
        BaseMod.addRelic(new TalismanOfVengeance(), RelicType.SHARED);
    }
}
