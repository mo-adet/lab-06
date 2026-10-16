package com.example.lab_06

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class WizardTest {
    private lateinit var evilWizard: Wizard

    // Set up a new wizard before every single test
    @Before
    fun setUp() {
        evilWizard = Wizard("Evil Wizard", 30, 10)
    }

    @Test
    fun castSpell_explosion_successful() {
        val damageDealt = evilWizard.castSpell("Explosion")

        assertEquals(30, damageDealt) // spellPower of 10 * 3 = 30

        assertEquals(20, evilWizard.mana) // mana of 30 - 10 = 20
    }


    @Test
    fun castSpell_frostbite_successful() {
        val damageDealt = evilWizard.castSpell("Frostbite")

        assertEquals(20, damageDealt)      // spellPower of 10 * 2 = 20
        assertEquals(25, evilWizard.mana)  // mana of 30 - 5 = 25
    }

    @Test
    fun castSpell_frostbite_notEnoughMana() {
        val weakWizard = Wizard("Weak Wizard", 2, 10) // 2 mana < 5 needed

        val damageDealt = weakWizard.castSpell("Frostbite")

        assertEquals(0, damageDealt)       // spell fails, no damage
        assertEquals(2, weakWizard.mana)   // mana is not spent on a failed cast
}