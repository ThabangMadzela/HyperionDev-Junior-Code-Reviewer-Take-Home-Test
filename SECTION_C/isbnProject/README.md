# ISBN PROJECT

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

    Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Test and run
### to run on on Linux, macOS and Windows operating systems
#### HAVE the following tools already avail
> * JDK (latest version)
> * VS Code(latest Vresion)

#### Extension to have in VS Code
> * Debugger For Java
> * Extension Pack for Java
> * Test Runner for Java

#### Now download this repo 
> * open VS Code 
> * in VS Code go to `Open Folder` navigate to the downloaded repo > SECTION_C then open this `isbnProject` folder
> * once openned in src click `ISBN.java` and `ISBNTest.java`
> * to run either , click on run icon on top left corner of the open file in the VS Code window

## The worst-case space complexity of the isbn13
    The worst-case space complexity of the isbn13 method is O(n), 
    where n is the length of the input string. This is because the method 
    creates a new string variable isbn and copies the converted 
    ISBN-13 or the string "Valid" or "Invalid" into it before returning 
    it. In the worst case, the input string is a valid ISBN-10, so the 
    method needs to create a new string of length 13 with "978" and the 
    first 9 characters of the input string, plus one additional character f
    or the check digit. Therefore, the worst-case space complexity of the 
    isbn13 method is O(n) because the space required by the method is proportional 
    to the length of the input string.







