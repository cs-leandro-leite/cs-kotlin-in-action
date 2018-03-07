# cs-kotlin-in-action

### Repositório com os códigos e conteúdos do livro Kotlin in Action

#### Índice

* 2 Kotlin basics
   * 2.1 Basic elements: functions and variables
       * [2.1.1 Hello, world!](src/main/kotlin/ch2/helloWorld.kt)
       * [2.1.2 Functions](src/test/kotlin/ch2/functions.kt)
       * [2.1.3 Variables](src/test/kotlin/ch2/variables.kt)
       * [2.1.4 Easier string formatting: string templates](src/test/kotlin/ch2/stringTemplates.kt)
   * [2.2 Classes and properties](src/test/kotlin/ch2/classes.kt)
       * [2.2.1 Properties](src/test/kotlin/ch2/classes.kt)
       * [2.2.2 Custom accessors](src/test/kotlin/ch2/customAccessors.kt)
       * [2.2.3 Kotlin source code layout: directories and packages](src/main/kotlin/ch2/geometryShapes.kt)
   * 2.3 Representing and handling choices: enums and “when”
       * [2.3.1 Declaring enum classes](src/test/kotlin/ch2/enumWhen.kt)
       * [2.3.2 Using “when” to deal with enum classes](src/test/kotlin/ch2/enumWhen.kt)
       * [2.3.3 Using “when” with arbitrary objects](src/test/kotlin/ch2/enumWhen.kt)
       * 2.3.4 Using “when” without an argument
       * [2.3.5 Smart casts: combining type checks and casts](src/test/kotlin/ch2/smartCast.kt)
       * [2.3.6 Refactoring: replacing “if” with “when”](src/test/kotlin/ch2/smartCast.kt)
       * 2.3.7 Blocks as branches of “if” and “when”
   * 2.4 Iterating over things: “while” and “for” loops
       * [2.4.1 The “while” loop](src/test/kotlin/ch2/iterating.kt)
       * [2.4.2 Iterating over numbers: ranges and progressions](src/test/kotlin/ch2/iterating.kt)
       * [2.4.3 Iterating over maps](src/test/kotlin/ch2/iterating.kt)
       * [2.4.4 Using “in” to check collection and range membership](src/test/kotlin/ch2/iterating.kt)
   * [2.5 Exceptions in Kotlin](src/test/kotlin/ch2/exceptions.kt)
       * [2.5.1 “try”, “catch”, and “finally”](src/test/kotlin/ch2/exceptions.kt)
       * [2.5.2 “try” as an expression](src/test/kotlin/ch2/exceptions.kt)
* 3 Defining and calling functions
    * [3.1 Creating collections in Kotlin](src/test/kotlin/ch3/collections.kt)
    * 3.2 Making functions easier to call
       * [3.2.1 Named arguments](src/test/kotlin/ch3/easierToCall.kt)
       * [3.2.2 Default parameter values](src/test/kotlin/ch3/easierToCall.kt)
       * 3.2.3 Getting rid of static utility classes: top-level functions and properties: [src](src/main/kotlin/ch3/strings.kt) [test](src/test/kotlin/ch3/noStaticUtils.kt)
    * 3.3 Adding methods to other people’s classes: extension functions and properties: [src](src/main/kotlin/ch3/extensions.kt) [test](src/test/kotlin/ch3/extensions.kt)
        * 3.3.1 Imports and extension functions: [src](src/main/kotlin/ch3/extensions.kt) [test](src/test/kotlin/ch3/extensions.kt)
        * 3.3.2 Calling extension functions from Java
        * 3.3.3 Utility functions as extensions: [src](src/main/kotlin/ch3/extensions.kt) [test](src/test/kotlin/ch3/extensions.kt)
        * 3.3.4 No overriding for extension functions: [src](src/main/kotlin/ch3/extensions.kt) [test](src/test/kotlin/ch3/extensions.kt)
        * 3.3.5 Extension properties: [src](src/main/kotlin/ch3/extensions.kt) [test](src/test/kotlin/ch3/extensions.kt)
    * 3.4 Working with collections: varargs, infix calls, and library support
        * 3.4.1 Extending the Java Collections API
        * [3.4.2 Varargs: functions that accept an arbitrary number of arguments](src/test/kotlin/ch3/vararg.kt)
        * [3.4.3 Working with pairs: infix calls and destructuring declarations](src/test/kotlin/ch3/infix.kt)
    * 3.5 Working with strings and regular expressions
        * [3.5.1 Splitting strings](src/test/kotlin/ch3/stringsRegex.kt)
        * [3.5.2 Regular expressions and triple-quoted strings](src/test/kotlin/ch3/stringsRegex.kt)
        * [3.5.3 Multiline triple-quoted strings](src/test/kotlin/ch3/stringsRegex.kt)
        * [3.6 Making your code tidy: local functions and extensions](src/test/kotlin/ch3/localFunctions.kt)
* 4 Classes, objects, and interfaces
    * 4.1 Defining class hierarchies
        * [4.1.1 Interfaces in Kotlin](src/test/kotlin/ch4/interfaces.kt)
        * [4.1.2 Open, final, and abstract modifiers: final by default](src/main/kotlin/ch4/modifiers.kt)
        * [4.1.3 Visibility modifiers: public by default](src/main/kotlin/ch4/modifiers.kt)
        * [4.1.4 Inner and nested classes: nested by default](src/main/kotlin/ch4/modifiers.kt)
        * [4.1.5 Sealed classes: defining restricted class hierarchies](src/main/kotlin/ch4/modifiers.kt)
    * 4.2 Declaring a class with nontrivial constructors or properties
        * [4.2.1 Initializing classes: primary constructor and initializer blocks](src/test/kotlin/ch4/declaring.kt)
        * [4.2.2 Secondary constructors: initializing the superclass in different ways](src/main/kotlin/ch4/declaring.kt)
        * [4.2.3 Implementing properties declared in interfaces](src/test/kotlin/ch4/declaring.kt)
        * [4.2.4 Accessing a backing field from a getter or setter](src/main/kotlin/ch4/modifiers.kt)
    