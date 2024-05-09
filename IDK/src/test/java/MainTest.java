import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.m0d3rn1ca.Main;

public class MainTest {
    @Test
    public void naturalRegex() {
        assertTrue(Main.regexNatural("1"));
        assertTrue(Main.regexNatural("13"));
        assertFalse(Main.regexNatural(""));
        assertFalse(Main.regexNatural("  "));
        assertFalse(Main.regexNatural("-117"));

        assertFalse(Main.regexNatural("abracadbra"));
        assertFalse(Main.regexNatural("02"));
        assertFalse(Main.regexNatural("003"));
        assertFalse(Main.regexNatural("-4"));
        assertFalse(Main.regexNatural("-0"));

        assertFalse(Main.regexNatural("0"));
        assertTrue(Main.regexNatural("23456654"));
        assertFalse(Main.regexNatural("-345678"));
        assertFalse(Main.regexNatural("-088"));
        assertFalse(Main.regexNatural("--9990017"));

        assertFalse(Main.regexNatural("l00000g"));
        assertFalse(Main.regexNatural("k10en"));
        assertFalse(Main.regexNatural("m1-ka-s0"));
        assertFalse(Main.regexNatural("0000343243"));
        assertFalse(Main.regexNatural("m1234k"));
    }

    @Test
    public void floatRegex() {
        assertTrue(Main.regexFloat("1.0"));
        assertTrue(Main.regexFloat("3.1415"));
        assertFalse(Main.regexFloat(""));
        assertFalse(Main.regexFloat("  "));
        assertFalse(Main.regexFloat("-117"));

        assertTrue(Main.regexFloat("11.4"));
        assertFalse(Main.regexFloat(".4534525"));
        assertTrue(Main.regexFloat("0.34353"));
        assertFalse(Main.regexFloat("000.4535"));
        assertTrue(Main.regexFloat("0.000005"));

        assertTrue(Main.regexFloat("-0.55"));
        assertTrue(Main.regexFloat("-0.0"));
        assertFalse(Main.regexFloat("-0"));
        assertTrue(Main.regexFloat("-100.0000"));
        assertFalse(Main.regexFloat("-heist0.4"));

        assertFalse(Main.regexFloat("00.00"));
        assertFalse(Main.regexFloat("-00.00"));
        assertTrue(Main.regexFloat("144.07"));
        assertFalse(Main.regexFloat("67"));
        assertFalse(Main.regexFloat("-01"));
    }

    @Test
    public void emailRegex() {
        assertFalse(Main.regexEmail("00"));
        assertFalse(Main.regexEmail("124rfr"));
        assertFalse(Main.regexEmail(""));
        assertFalse(Main.regexEmail("  "));
        assertFalse(Main.regexEmail("egrwe"));

        assertFalse(Main.regexEmail("mail@hnvv,"));
        assertTrue(Main.regexEmail("petya-vanec5.hkin@eblan-sci.edu.me"));
        assertTrue(Main.regexEmail("dima@mail.ru"));
        assertTrue(Main.regexEmail("andrey.sokolov@gmail.ru"));
        assertTrue(Main.regexEmail("k.a.zaitsev@stud.mospolytech.ru"));

        assertFalse(Main.regexEmail("кирил@мейл.ру"));
        assertTrue(Main.regexEmail("corsica-mir@mimir.edu.com"));
        assertFalse(Main.regexEmail("@"));
        assertFalse(Main.regexEmail("kirov@мейл.ру"));
        assertTrue(Main.regexEmail("kirov@admin.hk"));

        assertFalse(Main.regexEmail("hlr"));
        assertFalse(Main.regexEmail("hlgjgmk"));
        assertFalse(Main.regexEmail("144.07"));
        assertFalse(Main.regexEmail("67"));
        assertFalse(Main.regexEmail("-01"));
    }
}
