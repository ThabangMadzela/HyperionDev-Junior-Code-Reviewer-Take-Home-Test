/**	
 *	test suite for ISBN.java
 *
 *@author Thabang Thubane
 *@version 19 April 2023
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ISBNTest {
    
    /** *************TESTING isNumeric method******** */
    /** *************TESTING isNumeric method******** */
    /** *************TESTING isNumeric method******** */

    @Test
    // if strNum is null in isNumeric mrthod
    public void nullisNumeric(){
        var isbn = new ISBN();

        assertEquals(false, isbn.isNumeric(null));
    }

    @Test
    //when strNum is valid / numeric 
    public void strNumisNumeric(){
        var isbn = new ISBN();

        assertEquals(true, isbn.isNumeric("33"));
    }

    @Test
    // strNum is not numeric 
    public void testisNumeric(){
        var isbn = new ISBN();

        assertEquals(false, isbn.isNumeric("12345t"));
    }
    @Test
    // strNum is len 10 and has X at the end 
    public void testXisNumeric(){
        var isbn = new ISBN();

        assertEquals(true, isbn.isNumeric("123456789X"));
    }

    @Test
    // strNum is an empty string
    public void testnoneisNumeric(){
        var isbn = new ISBN();

        assertEquals(false, isbn.isNumeric(""));
    }

    /** *************TESTING byThreeOne method******** */
    /** *************TESTING byThreeOne method******** */
    /** *************TESTING byThreeOne method******** */

    @Test
    //if len strNum is even
    public void evenbyThreeOne(){
        var isbn = new ISBN();

        assertEquals(38, isbn.byThreeOne("5634"));
    }

    @Test
    //if len strNum is odd
    public void oddbyThreeOne(){
        var isbn = new ISBN();

        assertEquals(45, isbn.byThreeOne("56347"));
    }

    /** *************TESTING isISBN10 method******** */
    /** *************TESTING isISBN10 method******** */
    /** *************TESTING isISBN10 method******** */

    @Test
    //strNum is len 10 but not isbn10
    public void tenISBN10(){
        var isbn = new ISBN();

        assertEquals(false, isbn.isISBN10("4566675555"));
    }

    @Test
    //strnum is isbn10
    public void isbn10ISBN10(){
        var isbn = new ISBN();

        assertEquals(true, isbn.isISBN10("0330301624"));
    }

    @Test
    //isbn10 with X at end
    public void isbn10XISBN10(){
        var isbn = new ISBN();

        assertEquals(true, isbn.isISBN10("123456789X"));
    }

    /** *************TESTING isbn13 method******** */
    /** *************TESTING isbn13 method******** */
    /** *************TESTING isbn13 method******** */
    /** *************TESTING isbn13 method******** */

    @Test
    //non numeric strNum
    public void nonNumISBN13(){
        var isbn = new ISBN();

        assertEquals("Invalid", isbn.isbn13("033030*1624"));
    }

    @Test
    // strNum is isbn13
    public void isbnISBN13(){
        var isbn = new ISBN();

        assertEquals("Valid", isbn.isbn13("9780316066525"));
    }

    @Test
    // strNum is isbn10
    public void isbnToISBN13(){
        var isbn = new ISBN();

        assertEquals("9780330301626", isbn.isbn13("0330301624"));
    }

    @Test
    // strNum is isbn10 with X
    public void isbnXToISBN13(){
        var isbn = new ISBN();

        assertEquals("9781234567897", isbn.isbn13("123456789X"));
    }

    @Test
    // isbn10 with rem 0
    public void isbnRem0ISBN10(){
        var isbn = new ISBN();

        assertEquals("9780140266900", isbn.isbn13("0140266909"));
    }

    @Test
    // numeric but not isbn
    public void numNotISBN(){
        var isbn = new ISBN();

        assertEquals("Invalid", isbn.isbn13("03301624"));
    }

    
}
