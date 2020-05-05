package se.lexicon.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    public static final String NAME = "Test";
    public static final int STRENGTH = 8;
    public static final int MAX_LIFE = 24;
    private Player testObject;

    @Before
    public void setup(){
        testObject = new Player(
                NAME,
                STRENGTH,
                MAX_LIFE
        );
    }

    @Test
    public void testObject_successfully_created(){
        assertEquals(NAME, testObject.getName());
        assertEquals(STRENGTH, testObject.getStrength());
        assertEquals(MAX_LIFE, testObject.getMaxLife());
        assertEquals(MAX_LIFE, testObject.getLife());
        assertEquals(0, testObject.getScore());
        assertEquals(0, testObject.getHistory().length);
    }

    @Test
    public void given_newName_setName_should_update_name(){
        String newName = "Erik";
        testObject.setName(newName);

        assertEquals(newName, testObject.getName());
    }

    @Test
    public void given_someScore_setScore_should_update_score(){
        int someScore = 10;
        int expectedScore = 10;

        testObject.setScore(someScore);

        assertEquals(expectedScore, testObject.getScore());
    }

    @Test
    public void given_randomModifier_attack_returns_expected_value(){
        int randomModifier = 4;
        int expectedValue = 12;

        int result = testObject.attack(randomModifier);

        assertEquals(expectedValue, result);
    }

    @Test
    public void having_lifeOf_1_testObject_is_alive(){
        testObject.setLife(1);

        assertTrue(testObject.isAlive());
    }

    @Test
    public void having_lifeOf_0_testObject_is_not_alive(){
        testObject.setLife(0);

        assertFalse(testObject.isAlive());
    }

    @Test
    public void given_string_addBattleHistory_adds_string_to_array(){
        String string = "Test";
        String[] expected = {string};
        int expectedLength = 1;

        testObject.addBattleHistory(string);

        assertArrayEquals(expected, testObject.getHistory());
        assertEquals(expectedLength, testObject.getHistory().length);

    }





}
