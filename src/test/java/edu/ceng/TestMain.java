package edu.ceng;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class TestMain {

    @Test
    public void test1() {
        Route route = Main.findLongest(3);
        Assert.assertEquals(route.toString(), "4570km:EDİRNE->HAKKARİ->MUĞLA->EDİRNE");
    }

    @Test
    public void test2() {
        Route route = Main.findShortest(3);
        Assert.assertEquals(route.toString(), "204km:KOCAELİ->SAKARYA->YALOVA->KOCAELİ");
    }

    @Test
    public void test3() {
        Route route = Main.findLongest(2);
        Assert.assertEquals(route.toString(), "4084km:EDİRNE->HAKKARİ->EDİRNE");
    }

    @Test
    public void test4() {
        Route route = Main.findShortest(2);
        Assert.assertEquals(route.toString(), "72km:İZMİR->MANİSA->İZMİR");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        Main.main(new String[]{"-n", "1", "-p", P.LONGEST.toString()});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test6() {
        Main.main(new String[]{"-p", P.LONGEST.toString(), "-n", "1"});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        Main.main(new String[]{"-n", "82", "-p", P.LONGEST.toString()});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test8() {
        Main.main(new String[]{"-p", P.LONGEST.toString(), "-n", "82"});
    }

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();


    @Test
    public void test9() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{});
    }

    @Test
    public void test10() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p"});
    }

    @Test
    public void test11() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "porsuk"});
    }

    @Test
    public void test12() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "LONGEST"});
    }

    @Test
    public void test13() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "SHORTEST"});
    }

    @Test
    public void test14() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "LONGEST", "-n"});
    }

    @Test
    public void test15() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "SHORTEST", "-n"});
    }

    @Test
    public void test16() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "LONGEST", "-num"});
    }

    @Test
    public void test17() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "SHORTEST", "-num"});
    }

    @Test
    public void test18() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "LONGEST", "-n", "bir"});
    }

    @Test
    public void test19() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "SHORTEST", "-n", "iki"});
    }

    @Test
    public void test20() {
        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{"-p", "LONGEST", "-n", "4"});
    }

    @Test
    public void test21() {
        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{"-p", "SHORTEST", "-n", "4"});
    }

    @Test
    public void test22() {
        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{"-n", "5", "-p", "LONGEST"});
    }

    @Test
    public void test23() {
        exit.expectSystemExitWithStatus(0);
        Main.main(new String[]{"-n", "5", "-p", "SHORTEST"});
    }


    @Test
    public void test24() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "LONGEST", "-n", "4", "-k"});
    }

    @Test
    public void test25() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "SHORTEST", "-n", "4", "-k"});
    }

    @Test
    public void test26() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "LONG", "-n", "4"});
    }

    @Test
    public void test27() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-p", "SHORT", "-n", "4"});
    }

    @Test
    public void test28() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-n", "5", "-p", "LONG"});
    }

    @Test
    public void test29() {
        exit.expectSystemExitWithStatus(1);
        Main.main(new String[]{"-n", "5", "-p", "SHORT"});
    }
}

